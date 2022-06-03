package com.example.myloginapp;

public class CustomShopCartItem {
	String itemName;
	String itemPrice;
	String itemExtra;

	public CustomShopCartItem(String itemName, String itemPrice, String itemExtra) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemExtra = itemExtra;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemExtra() {
		return itemExtra;
	}

	public void setItemExtra(String itemExtra) {
		this.itemExtra = itemExtra;
	}
}
