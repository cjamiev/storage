package com.cjv.storage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Name {
    @Id
    private String id;
    private boolean is_first_name;
    private boolean is_last_name;
    private char gender;

    public Name(String id, boolean is_first_name, boolean is_last_name, char gender) {
        this.id = id;
        this.is_first_name = is_first_name;
        this.is_last_name = is_last_name;
        this.gender = gender;
    }

    public static Name getEmptyName() {
        return new Name("", true, true, 'o');
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIs_first_name() {
        return this.is_first_name;
    }

    public void setIs_first_name(boolean is_first_name) {
        this.is_first_name = is_first_name;
    }

    public boolean getIs_last_name() {
        return this.is_last_name;
    }

    public void setIs_last_name(boolean is_last_name) {
        this.is_last_name = is_last_name;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + id
                + "\", \"is_first_name\":\"" + is_first_name
                + "\", \"is_last_name\":\"" + is_last_name
                + "\", \"gender\":\"" + gender
                + "\"}";
    }
}
