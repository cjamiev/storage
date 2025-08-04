package com.cjv.storage.repository;

import com.cjv.storage.models.Email;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailRowMapper implements RowMapper<Email> {
    @Override
    public Email mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id =  rs.getString("id");

        return new Email(id);
    }
}

