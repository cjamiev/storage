package com.cjv.storage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class City {
    @Id
    private String id;
    private String origin;

    public City(String id, String origin) {
        this.id = id;
        this.origin = origin;
    }

    public static City getEmptyCity() {
        return new City("", "");
    }

    public String getId() {
        return id;
    }

    public void setCode(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + id
                + "\", \"origin\":\"" + origin
                + "\"}";
    }
}
