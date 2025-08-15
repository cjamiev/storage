package com.cjv.storage.services;

import com.cjv.storage.models.Url;
import com.cjv.storage.repository.UrlRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UrlService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UrlService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Url> getAllUrls() {
        String sql = "SELECT * FROM public.url";

        Optional<List<Url>> retrievedUrls = Optional.of(jdbcTemplate.query(sql, new UrlRowMapper()));
        List<Url> emptyList = new ArrayList<>();
        emptyList.add(Url.getEmptyUrl());

        return retrievedUrls.orElse(emptyList);
    }

    public int addNewUrl(Url url) {
        String sql = "INSERT INTO public.url(id, category) VALUES (?, ?)";

        return jdbcTemplate.update(
                sql,
                url.getId(),
                url.getCategory()
        );
    }

    public int updateUrl(Url url) {
        String sql = "UPDATE public.url SET category=? WHERE id = ?;";

        return jdbcTemplate.update(
                sql,
                url.getCategory(),
                url.getId()
        );
    }

    public int deleteUrl(String id) {
        String sql = "DELETE FROM public.url WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                id
        );
    }
}