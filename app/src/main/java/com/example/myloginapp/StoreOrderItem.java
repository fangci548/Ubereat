package com.example.myloginapp;
public class StoreOrderItem {
  String mark;
  String num;
  String time;

  public StoreOrderItem(String mark, String num, String time) {
    this.mark = mark;
    this.num = num;
    this.time = time;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

}
