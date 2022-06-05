package com.example.myloginapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomShopCartAdapter extends ArrayAdapter<CustomShopCartItem> {
    private Context context;
    private LayoutInflater inflater;
    private List<CustomShopCartItem> products;

    public CustomShopCartAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CustomShopCartItem> products) {
        super(context, resource, products);
        this.context = context;
        this.products = products;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout itemLayout = null;

        if (convertView == null) {
            itemLayout = (LinearLayout) inflater.inflate(R.layout.customer_shop_cart_list, null);
        } else {
            itemLayout = (LinearLayout) convertView;
        }

        CustomShopCartItem item = products.get(position);

        TextView itemname = itemLayout.findViewById(R.id.itemName);
        TextView itemprice = itemLayout.findViewById(R.id.itemPrice);
        TextView itemextra = itemLayout.findViewById(R.id.item_des);
        itemname.setText(item.getItemName());
        itemprice.setText(item.getItemPrice());
        itemextra.setText(item.getItemExtra());

        return itemLayout;
    }
}
