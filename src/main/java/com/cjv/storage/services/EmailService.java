package com.cjv.storage.services;

import com.cjv.storage.models.Email;
import com.cjv.storage.repository.EmailRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmailService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Email> getAllEmails() {
        String sql = "SELECT * FROM public.email";

        Optional<List<Email>> retrievedEmails = Optional.of(jdbcTemplate.query(sql, new EmailRowMapper()));
        List<Email> emptyList = new ArrayList<>();
        emptyList.add(Email.getEmptyEmail());

        return retrievedEmails.orElse(emptyList);
    }

    public int addNewEmail(Email email) {
        String sql = "INSERT INTO public.email(id) VALUES (?)";

        return jdbcTemplate.update(
                sql,
                email.getId()
        );
    }

    public int deleteEmail(String id) {
        String sql = "DELETE FROM public.email WHERE id = ?";

        return jdbcTemplate.update(
                sql,
                id
        );
    }
}
