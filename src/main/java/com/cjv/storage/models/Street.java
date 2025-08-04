package com.cjv.storage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Street {
    @Id
    private String id;

    public Street(String id) {
        this.id = id;
    }

    public static Street getEmptyStreet() {
        return new Street("");
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
