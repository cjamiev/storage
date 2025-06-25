package com.cjv.library.services;

import com.cjv.library.models.Name;
import com.cjv.library.repository.NameRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NameService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NameService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Name> getNames() {
        String sql = "SELECT * FROM main.names";

        return jdbcTemplate.query(sql, new NameRowMapper());
    }

    public Name getSearchedNames(String name) {
        String sql = "SELECT * FROM main.names WHERE name = ?";

        Optional<Name> retrievedName = jdbcTemplate.query(sql, new NameRowMapper(), name).stream().findFirst();

        return retrievedName.orElse(Name.getEmptyName());
    }

    public int addName(Name name) {
        String sql = "INSERT INTO main.names(name, gender, origin, is_real_name) VALUES (?, ?, ?, ?);";

        return jdbcTemplate.update(sql, name.getName(), name.getGender(), name.getOrigin(), name.getIsRealName());
    }

    public int updateName(Name name) {
        String sql = "UPDATE main.names SET gender=?, origin=?, is_real_name=? WHERE name=?";

        return jdbcTemplate.update(sql, name.getGender(), name.getOrigin(), name.getIsRealName(), name.getName());
    }

    public int deleteName(String name) {
        String sql = "DELETE FROM main.names WHERE name = ?";

        return jdbcTemplate.update(sql, name);
    }
}
