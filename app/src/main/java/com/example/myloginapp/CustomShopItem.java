package com.example.myloginapp;

public class CustomShopItem {
    int image;
    String Name;
    String price;
    String des;

    public CustomShopItem(int image, String name, String price, String des) {
        this.image = image;
        this.Name = name;
        this.price = price;
        this.des = des;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
