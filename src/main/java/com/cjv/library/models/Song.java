package com.cjv.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Song {
    @Id
    private String id;
    private String name;
    private String album;
    private String platforms;
    private String interest;
    private String link;

    public Song(String id, String name, String album, String platforms, String interest, String link) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.platforms = platforms;
        this.interest = interest;
        this.link = link;
    }

    public static Song getEmptySong() {
        return new Song("", "", "", "", "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album.toString();
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                "name=" + name +
                ", album='" + album + '\'' +
                ", platforms='" + platforms + '\'' +
                ", interest='" + interest + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
