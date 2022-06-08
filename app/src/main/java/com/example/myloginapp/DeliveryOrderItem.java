package com.example.myloginapp;

public class DeliveryOrderItem {
    String orderNumber;
    String shopName;
    String deliveryFee;
    String distance;

    public DeliveryOrderItem(String orderNumber, String shopName, String deliveryFee, String distance) {
        this.orderNumber = orderNumber;
        this.shopName = shopName;
        this.deliveryFee = deliveryFee;
        this.distance = distance;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
