package com.example.myloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StoreShopItemAdapter extends ArrayAdapter<StoreShopItem> {
    private Context context;
    private ArrayList<StoreShopItem> products;

    public StoreShopItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<StoreShopItem> products) {
        super(context, resource, products);
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout itemLayout = null;

        if (convertView == null) {
            itemLayout = (LinearLayout) inflater.inflate(R.layout.store_product_layout, null);
        } else {
            itemLayout = (LinearLayout) convertView;
        }

        StoreShopItem item = products.get(position);

        ImageView imageView = itemLayout.findViewById(R.id.store_product_img);
        TextView itemName = itemLayout.findViewById(R.id.store_product_name);
        TextView itemPrice = itemLayout.findViewById(R.id.store_product_price);
        TextView itemDescription = itemLayout.findViewById(R.id.store_product_des);
        imageView.setImageResource(item.getImage());
        itemName.setText(item.getName());
        itemPrice.setText("$" + item.getPrice());
        itemDescription.setText(item.getDescription());

        return itemLayout;
    }
}

