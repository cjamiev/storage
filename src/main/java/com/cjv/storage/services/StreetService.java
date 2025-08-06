package com.cjv.storage.services;

import com.cjv.storage.models.Street;
import com.cjv.storage.repository.StreetRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StreetService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StreetService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Street> getAllStreets() {
        String sql = "SELECT * FROM public.street";

        Optional<List<Street>> retrievedStreets = Optional.of(jdbcTemplate.query(sql, new StreetRowMapper()));
        List<Street> emptyList = new ArrayList<>();
        emptyList.add(Street.getEmptyStreet());

        return retrievedStreets.orElse(emptyList);
    }

    public int addNewStreet(Street street) {
        String sql = "INSERT INTO public.street(id) VALUES (?)";

        return jdbcTemplate.update(
                sql,
                street.getId()
        );
    }

    public int deleteStreet(String id) {
        String sql = "DELETE FROM public.street WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                id
        );
    }
}
