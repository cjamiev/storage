package com.cjv.storage.services;

import com.cjv.storage.models.Library;
import com.cjv.storage.repository.LibraryRowMapper;
import com.cjv.storage.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LibraryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Library> getEntireLibrary() {
        String sql = "SELECT * FROM public.library";

        return jdbcTemplate.query(sql, new LibraryRowMapper());
    }

    public int backupLibrary() {
        List<Library> contents = getEntireLibrary();

        return  FileUtil.backupDB(contents.toString());
    }

    public Library getSpecificType(String type) {
        String sql = "SELECT * FROM public.library WHERE type = ?";

        Optional<Library> retrievedLibrary = jdbcTemplate.query(sql, new LibraryRowMapper(), type).stream().findFirst();

        return retrievedLibrary.orElse(Library.getEmptyLibrary());
    }

    public int addNewTypeToLibrary(String type) {
        String sql = "INSERT INTO public.library(type, records) VALUES (?, ?);";

        return jdbcTemplate.update(sql, type, "");
    }

    public int updateRecordsInLibrary(Library library) {
        String sql = "UPDATE public.library SET records=? WHERE type=?";

        return jdbcTemplate.update(sql, library.getRecords(), library.getType());
    }
}
