package com.cjv.storage.services;

import com.cjv.storage.models.Random;
import com.cjv.storage.repository.RandomRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RandomService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RandomService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Random> getAllRandoms() {
        String sql = "SELECT * FROM public.random";

        Optional<List<Random>> retrievedRandoms = Optional.of(jdbcTemplate.query(sql, new RandomRowMapper()));
        List<Random> emptyList = new ArrayList<>();
        emptyList.add(Random.getEmptyRandom());

        return retrievedRandoms.orElse(emptyList);
    }

    public int addNewRandom(Random random) {
        String sql = "INSERT INTO public.random(id, type) VALUES (?, ?)";

        return jdbcTemplate.update(
                sql,
                random.getId(),
                random.getType()
        );
    }
}
