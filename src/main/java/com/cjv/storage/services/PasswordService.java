package com.cjv.storage.services;

import com.cjv.storage.models.Password;
import com.cjv.storage.repository.PasswordRowMapper;
import com.cjv.storage.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PasswordService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PasswordService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Password> getAllPasswords() {
        String sql = "SELECT * FROM public.password";

        Optional<List<Password>> retrievedPasswords = Optional.of(jdbcTemplate.query(sql, new PasswordRowMapper()));
        List<Password> emptyList = new ArrayList<>();
        emptyList.add(Password.getEmptyPassword());

        return retrievedPasswords.orElse(emptyList);
    }

    public int addNewPassword(Password password) {
        String sql = "INSERT INTO public.password(id, username, password, url, created_date, tags, history) VALUES (?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql, password.getId(), password.getUsername(), password.getPassword(), password.getUrl(), password.getCreatedDate(), password.getTags(), password.getHistory());
    }

    public int updatePassword(Password password) {
        String sql = "UPDATE public.password SET password=?, url=?, created_date=?, tags=?, history=? WHERE id = ?;";

        return jdbcTemplate.update(sql, password.getPassword(), password.getUrl(), password.getCreatedDate(), password.getTags(), password.getHistory(), password.getId());
    }

    public int backupPasswords() {
        List<Password> retrievedPasswords = getAllPasswords();

        return  FileUtil.backupDB("passwords", retrievedPasswords.toString());
    }

}
