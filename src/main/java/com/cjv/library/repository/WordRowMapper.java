package com.cjv.library.repository;

import com.cjv.library.models.Word;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WordRowMapper implements RowMapper<Word> {
    @Override
    public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        String type =  rs.getString("type");
        String definition = rs.getString("definition");
        String tags = rs.getString("tags");
        boolean isRealWord = rs.getBoolean("is_real_word");

        return new Word(name, type, definition, tags, isRealWord);
    }
}
