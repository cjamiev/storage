package com.cjv.storage.repository;

import com.cjv.storage.models.Random;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RandomRowMapper implements RowMapper<Random> {
    @Override
    public Random mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id =  rs.getString("id");
        String type = rs.getString("type");

        return new Random(id, type);
    }
}

