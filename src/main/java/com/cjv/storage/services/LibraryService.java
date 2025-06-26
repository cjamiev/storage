package com.cjv.storage.services;

import com.cjv.storage.models.Library;
import com.cjv.storage.repository.LibraryRowMapper;
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

    public Library getSpecificType(String type) {
        String sql = "SELECT * FROM public.library WHERE type = ?";

        Optional<Library> retrievedLibrary = jdbcTemplate.query(sql, new LibraryRowMapper(), type).stream().findFirst();

        return retrievedLibrary.orElse(Library.getEmptyLibrary());
    }

    public int addNewTypeToLibrary(Library library) {
        String sql = "INSERT INTO public.library(type, records) VALUES (?, ?);";

        return jdbcTemplate.update(sql, library.getType(), library.getRecords());
    }

    public int updateRecordsInLibrary(Library library) {
        String sql = "UPDATE public.library SET records=? WHERE type=?";

        return jdbcTemplate.update(sql, library.getRecords(), library.getType());
    }
}
