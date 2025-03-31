package org.example.mcdonald.models;

public class Products {
    private int id;
    private String type;
    private String name;
    private String img;

    public Products(int id, String type, String name, String img) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.img = img;
    }

    public Products() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
