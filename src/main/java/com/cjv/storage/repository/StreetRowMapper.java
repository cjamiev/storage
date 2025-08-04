package com.cjv.storage.repository;

import com.cjv.storage.models.Street;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StreetRowMapper implements RowMapper<Street> {
    @Override
    public Street mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id =  rs.getString("id");

        return new Street(id);
    }
}
