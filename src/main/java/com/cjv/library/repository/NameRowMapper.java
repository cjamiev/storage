package com.cjv.library.repository;

import com.cjv.library.models.Name;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NameRowMapper implements RowMapper<Name> {
    @Override
    public Name mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        String gender =  rs.getString("gender");
        String origin = rs.getString("origin");
        boolean isRealName = rs.getBoolean("is_real_Name");

        return new Name(name, gender, origin, isRealName);
    }
}