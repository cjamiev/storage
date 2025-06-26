package com.cjv.storage.repository;

import com.cjv.storage.models.Library;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryRowMapper implements RowMapper<Library> {
    @Override
    public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
        String type = rs.getString("type");
        String records =  rs.getString("records");

        return new Library(type, records);
    }
}

