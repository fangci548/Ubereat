package com.example.myloginapp;

public class OrderDetailItem {
  String value;
  String name;
  String num;
  String price;

  public OrderDetailItem(String value, String name, String num, String price) {
    this.value = value;
    this.name = name;
    this.num = num;
    this.price = price;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }


}





