package com.cjv.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Show {
    @Id
    private String name;
    private String genre;
    private String platforms;
    private boolean is_film;

    public Show(String name, String genre, String platforms, boolean is_film) {
        this.name = name;
        this.genre = genre;
        this.platforms = platforms;
        this.is_film = is_film;
    }

    public static Show getEmptyShow() {
        return new Show("", "", "", false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Boolean getIsFilm() {
        return is_film;
    }

    public void setIsFilm(Boolean is_film) {
        this.is_film = is_film;
    }

    @Override
    public String toString() {
        return "Show{" +
                "name=" + name +
                ", genre='" + genre + '\'' +
                ", platforms='" + platforms + '\'' +
                ", is_film='" + is_film + '\'' +
                '}';
    }
}
