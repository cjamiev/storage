package com.cjv.storage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Url {
    @Id
    private String id;
    private String category;

    public Url(String id, String category) {
        this.id = id;
        this.category = category;
    }

    public static Url getEmptyUrl() {
        return new Url("", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + id
                + "\", \"category\":\"" + category
                + "\"}";
    }
}
