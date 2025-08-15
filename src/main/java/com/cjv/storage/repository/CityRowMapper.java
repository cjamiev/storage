package com.cjv.storage.repository;

import com.cjv.storage.models.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id =  rs.getString("id");
        String origin = rs.getString("origin");

        return new City(id, origin);
    }
}

