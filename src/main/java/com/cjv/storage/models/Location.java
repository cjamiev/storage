package com.cjv.storage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Location {
    @Id
    private String code;
    private String state;
    private String cities;

    public Location(String code, String state, String cities) {
        this.code = code;
        this.state = state;
        this.cities = cities;
    }

    public static Location getEmptyLocation() {
        return new Location("", "", "");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "{\"code\": \"" + code
                + "\", \"state\":\"" + state
                + "\", \"cities\":\"" + cities
                + "\"}";
    }
}
