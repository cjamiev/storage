package com.cjv.storage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Random {
    @Id
    private String id;
    private String type;

    public Random(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public static Random getEmptyRandom() {
        return new Random("", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + id
                + "\", \"type\":\"" + type
                + "\"}";
    }
}
