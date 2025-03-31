package org.example.mcdonald.models;

public class Charity {
    private Integer id;
    private Integer year;
    private String image;
    private String description;

    public Charity(Integer year, String image, String description) {
        this.year = year;
        this.image = image;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
