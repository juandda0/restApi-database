package com.juannn.restApiPractice.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "strong_typed", nullable = false)
    private boolean strongTyped;

    public Language() {}

    public Language(String name, Date releaseDate, boolean strongTyped) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.strongTyped = strongTyped;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isStrongTyped() {
        return strongTyped;
    }

    public void setStrongTyped(boolean strongTyped) {
        this.strongTyped = strongTyped;
    }
}
