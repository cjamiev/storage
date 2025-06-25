package com.cjv.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Name {
    @Id
    private String name;
    private String gender;
    private String origin;
    private boolean is_real_name;

    public Name(String name, String gender, String origin, boolean is_real_name) {
        this.name = name;
        this.gender = gender;
        this.origin = origin;
        this.is_real_name = is_real_name;
    }

    public static Name getEmptyName() {
        return new Name("", "", "", false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Boolean getIsRealName() {
        return is_real_name;
    }

    public void setIsRealName(Boolean is_real_name) {
        this.is_real_name = is_real_name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name=" + name +
                ", gender='" + gender + '\'' +
                ", origin='" + origin + '\'' +
                ", is_real_name='" + is_real_name + '\'' +
                '}';
    }
}
