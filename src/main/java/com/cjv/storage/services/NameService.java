package com.cjv.storage.services;

import com.cjv.storage.models.Name;
import com.cjv.storage.repository.NameRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NameService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NameService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Name> getAllNames() {
        String sql = "SELECT * FROM public.name";

        Optional<List<Name>> retrievedNames = Optional.of(jdbcTemplate.query(sql, new NameRowMapper()));
        List<Name> emptyList = new ArrayList<>();
        emptyList.add(Name.getEmptyName());

        return retrievedNames.orElse(emptyList);
    }

    public int addNewName(Name name) {
        String sql = "INSERT INTO public.name(id, is_first_name, is_last_name, gender) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                name.getId(),
                name.getIs_first_name(),
                name.getIs_last_name(),
                name.getGender()
        );
    }

    public int deleteName(String id) {
        String sql = "DELETE FROM public.name WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                id
        );
    }
}
