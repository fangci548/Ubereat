package com.example.myloginapp;

public class MemberItem {
  int img;
  String name;
  String id;

  public MemberItem(int img, String name, String id) {
    this.img = img;
    this.name = name;
    this.id = id;
  }

  public int getImg() { return img; }

  public void setImg(int img) {
    this.img = img;
  }

  public String getName() { return name; }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() { return id; }

  public void setId(String id) {
    this.id = id;
  }
}
