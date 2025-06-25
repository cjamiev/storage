package com.cjv.library.services;

import com.cjv.library.models.Word;
import com.cjv.library.repository.WordRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WordService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Word> getWords() {
        String sql = "SELECT * FROM main.words";

        return jdbcTemplate.query(sql, new WordRowMapper());
    }

    public Word getSearchedWords(String name) {
        String sql = "SELECT * FROM main.words WHERE name = ?";

        Optional<Word> retrievedWord = jdbcTemplate.query(sql, new WordRowMapper(), name).stream().findFirst();

        return retrievedWord.orElse(Word.getEmptyWord());
    }

    public int addWord(Word word) {
        String sql = "INSERT INTO main.words(name, type, definition, tags, is_real_word) VALUES (?, ?, ?, ?, ?);";

        return jdbcTemplate.update(sql, word.getName(), word.getType(), word.getDefinition(), word.getTags(), word.getIsRealWord());
    }

    public int updateWord(Word word) {
        String sql = "UPDATE main.words SET type=?, definition=?, tags=?, is_real_word=? WHERE name=?";

        return jdbcTemplate.update(sql, word.getType(), word.getDefinition(), word.getTags(), word.getIsRealWord(), word.getName());
    }

    public int deleteWord(String name) {
        String sql = "DELETE FROM main.words WHERE name = ?";

        return jdbcTemplate.update(sql, name);
    }
}
