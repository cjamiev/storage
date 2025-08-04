package com.cjv.storage.repository;

import com.cjv.storage.models.Name;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NameRowMapper implements RowMapper<Name> {
    @Override
    public Name mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id =  rs.getString("id");
        boolean is_first_name = rs.getBoolean("is_first_name");
        boolean is_last_name = rs.getBoolean("is_last_name");
        char gender = rs.getString("gender").charAt(0);

        return new Name(id, is_first_name, is_last_name, gender);
    }
}