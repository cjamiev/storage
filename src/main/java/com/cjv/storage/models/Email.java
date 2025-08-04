package com.cjv.storage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Email {
    @Id
    private String id;

    public Email(String id) {
        this.id = id;
    }

    public static Email getEmptyEmail() {
        return new Email("");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + id
                + "\"}";
    }
}
