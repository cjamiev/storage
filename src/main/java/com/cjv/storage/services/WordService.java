package com.cjv.storage.services;

import com.cjv.storage.models.Word;
import com.cjv.storage.repository.WordRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WordService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WordService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Word> getAllWords() {
        String sql = "SELECT * FROM public.word";

        Optional<List<Word>> retrievedWords = Optional.of(jdbcTemplate.query(sql, new WordRowMapper()));
        List<Word> emptyList = new ArrayList<>();
        emptyList.add(Word.getEmptyWord());

        return retrievedWords.orElse(emptyList);
    }

    public int addNewWord(Word word) {
        String sql = "INSERT INTO public.word(id, type) VALUES (?, ?)";

        return jdbcTemplate.update(
                sql,
                word.getId(),
                word.getType()
        );
    }

    public int deleteWord(String id) {
        String sql = "DELETE FROM public.word WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                id
        );
    }
}
