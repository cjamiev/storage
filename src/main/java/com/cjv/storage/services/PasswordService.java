package com.cjv.storage.services;

import com.cjv.storage.utils.EncryptAndDecrypt;
import com.cjv.storage.models.ConfigProperties;
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

    private final ConfigProperties configProperties;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PasswordService(JdbcTemplate jdbcTemplate, ConfigProperties configProperties) {
        this.jdbcTemplate = jdbcTemplate;
        this.configProperties = configProperties;
    }

    public List<Password> getAllPasswords(boolean shouldDecrypt) {
        String sql = "SELECT * FROM public.password";

        Optional<List<Password>> retrievedPasswords = Optional.of(jdbcTemplate.query(sql, new PasswordRowMapper(configProperties.getSecretkey(), shouldDecrypt)));
        List<Password> emptyList = new ArrayList<>();
        emptyList.add(Password.getEmptyPassword());

        return retrievedPasswords.orElse(emptyList);
    }

    public int addNewPassword(Password password) {
        EncryptAndDecrypt passwordEncryptor = new EncryptAndDecrypt(configProperties.getSecretkey());
        String sql = "INSERT INTO public.password(id, username, password, url, created_date, tags, history) VALUES (?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                password.getId(),
                password.getUsername(),
                passwordEncryptor.encrypt(password.getPassword()),
                password.getUrl(),
                password.getCreatedDate(),
                password.getTags(),
                passwordEncryptor.encrypt(password.getHistory())
        );
    }

    public int updatePassword(Password password) {
        EncryptAndDecrypt passwordEncryptor = new EncryptAndDecrypt(configProperties.getSecretkey());
        String sql = "UPDATE public.password SET password=?, url=?, created_date=?, tags=?, history=? WHERE id = ?;";

        return jdbcTemplate.update(
                sql,
                passwordEncryptor.encrypt(password.getPassword()),
                password.getUrl(),
                password.getCreatedDate(),
                password.getTags(),
                passwordEncryptor.encrypt(password.getHistory()),
                password.getId()
        );
    }

    public int backupPasswords() {
        List<Password> retrievedPasswords = getAllPasswords(false);

        return  FileUtil.backupDB("passwords", retrievedPasswords.toString());
    }

}
