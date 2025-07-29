package com.cjv.storage.repository;

import com.cjv.storage.utils.EncryptAndDecrypt;
import com.cjv.storage.models.Password;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordRowMapper implements RowMapper<Password> {
    private final String secretkey;
    private final boolean shouldDecrypt;

    public PasswordRowMapper (String secretkey, boolean shouldDecrypt) {
        this.secretkey = secretkey;
        this.shouldDecrypt = shouldDecrypt;
    }

    private String getCorrectString (String encryptedstr) {
        EncryptAndDecrypt passwordDecryptor = new EncryptAndDecrypt(secretkey);
        if(this.shouldDecrypt) {
            return passwordDecryptor.decrypt(encryptedstr);
        }

        return encryptedstr;
    }

    @Override
    public Password mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("id");
        String username = rs.getString("username");
        String encryptedPassword = rs.getString("password");
        String password = getCorrectString(encryptedPassword);
        String url = rs.getString("url");
        String createdDate = rs.getString("created_date");
        String tags = rs.getString("tags");
        String encryptedHistory = rs.getString("history");
        String history = getCorrectString(encryptedHistory);

        return new Password(id, username, password, url, createdDate, tags, history);
    }
}

