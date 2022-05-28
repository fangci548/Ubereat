package com.example.myloginapp;

public class StoreShopItem {
    int image;
    String Name;
    String price;
    String description;



    public StoreShopItem(int image, String name, String price, String description) {
        this.image = image;
        this.Name = name;
        this.price = price;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
