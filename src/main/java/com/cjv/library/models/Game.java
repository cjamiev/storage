package com.cjv.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Game {
    @Id
    private String name;
    private String genre;
    private String price;
    private String lowest_price;
    private String interest;
    private String release_date;
    private String notes;

    public Game(String name, String genre, String price, String lowest_price, String interest, String release_date, String notes) {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.lowest_price = lowest_price;
        this.interest = interest;
        this.release_date = release_date;
        this.notes = notes;
    }

    public static Game getEmptyGame() {
        return new Game("", "", "", "", "", "", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre.toString();
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLowestPrice() {
        return lowest_price;
    }

    public void setLowestPrice(String lowest_price) {
        this.lowest_price = lowest_price;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String release_date) {
        this.release_date = release_date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name=" + name +
                ", genre='" + genre + '\'' +
                ", price='" + price + '\'' +
                ", lowest_price='" + lowest_price + '\'' +
                ", interest='" + interest + '\'' +
                ", release_date='" + release_date + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
