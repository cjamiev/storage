package com.cjv.storage.repository;

import com.cjv.storage.models.Password;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordRowMapper implements RowMapper<Password> {
    @Override
    public Password mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String url = rs.getString("url");
        String createdDate = rs.getString("created_date");
        String tags = rs.getString("tags");
        String history = rs.getString("history");

        return new Password(id, username, password, url, createdDate, tags, history);
    }
}

