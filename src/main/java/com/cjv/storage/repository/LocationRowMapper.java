package com.cjv.storage.repository;

import com.cjv.storage.models.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        String code =  rs.getString("code");
        String state = rs.getString("state");
        String cities = rs.getString("cities");

        return new Location(code, state, cities);
    }
}

