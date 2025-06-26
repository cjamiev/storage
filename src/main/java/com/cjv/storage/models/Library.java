package com.cjv.storage.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Library {
    @Id
    private String type;
    private String records;

    public Library(String type, String records) {
        this.type = type;
        this.records = records;
    }

    public static Library getEmptyLibrary() {
        return new Library("", "");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String type) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Game{" +
                "type=" + type +
                ", records='" + records + '\'' +
                '}';
    }
}
