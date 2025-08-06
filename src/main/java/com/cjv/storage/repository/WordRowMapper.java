package com.cjv.storage.repository;

import com.cjv.storage.models.Word;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WordRowMapper implements RowMapper<Word> {
    @Override
    public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id =  rs.getString("id");
        String type = rs.getString("type");

        return new Word(id, type);
    }
}

