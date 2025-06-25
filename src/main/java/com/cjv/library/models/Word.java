package com.cjv.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Word {
    @Id
    private String name;
    private String type;
    private String definition;
    private String tags;
    private boolean is_real_word;

    public Word(String name, String type, String definition, String tags, boolean is_real_word) {
        this.name = name;
        this.type = type;
        this.definition = definition;
        this.tags = tags;
        this.is_real_word = is_real_word;
    }

    public static Word getEmptyWord() {
        return new Word("", "", "", "", false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type.toString();
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getIsRealWord() {
        return is_real_word;
    }

    public void setIsRealWord(Boolean is_real_word) {
        this.is_real_word = is_real_word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "name=" + name +
                ", type='" + type + '\'' +
                ", definition='" + definition + '\'' +
                ", tags='" + tags + '\'' +
                ", is_real_word='" + is_real_word + '\'' +
                '}';
    }
}
