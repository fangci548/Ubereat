package com.example.myloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomShopItemAdapter extends ArrayAdapter<CustomShopItem> {
    private Context context;
    private List<CustomShopItem> products;

    public CustomShopItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CustomShopItem> products) {
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
            itemLayout = (LinearLayout) inflater.inflate(R.layout.customer_shop_item, null);
        } else {
            itemLayout = (LinearLayout) convertView;
        }

        CustomShopItem item = products.get(position);

        ImageView imageView = itemLayout.findViewById(R.id.custom_shop_item_pt);
        TextView itemName = itemLayout.findViewById(R.id.custom_shop_item_name);
        TextView itemPrice = itemLayout.findViewById(R.id.custom_shop_item_price);
        TextView itemdes = itemLayout.findViewById(R.id.custom_store_product_des);

        imageView.setImageResource(item.getImage());
        itemName.setText(item.getName());
        itemPrice.setText(item.getPrice());
        itemdes.setText(item.getDes());

        return itemLayout;
    }
}

