package com.cjv.storage.repository;

import com.cjv.storage.models.Url;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UrlRowMapper implements RowMapper<Url> {
    @Override
    public Url mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id =  rs.getString("id");
        String category = rs.getString("category");

        return new Url(id, category);
    }
}