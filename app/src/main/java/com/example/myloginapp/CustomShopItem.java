package com.example.myloginapp;

public class CustomShopItem {
    int image;
    String Name;
    String price;

    public CustomShopItem(int image, String name, String price) {
        this.image = image;
        Name = name;
        this.price = price;
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
}
