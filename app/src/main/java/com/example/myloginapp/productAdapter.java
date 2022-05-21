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

public class productAdapter extends ArrayAdapter<product> {
    private Context context;
    private List<product> products;

    public productAdapter(@NonNull Context context, int resource, @NonNull ArrayList<product> products) {
        super(context, resource, products);
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        RelativeLayout itemLayout = null;

        if (convertView == null) {
            itemLayout = (RelativeLayout) inflater.inflate(R.layout.custom_shop_item, null);
        } else {
            itemLayout = (RelativeLayout) convertView;
        }

        product item = products.get(position);

        ImageView imageView = itemLayout.findViewById(R.id.image);
        TextView txtName = itemLayout.findViewById(R.id.txtName);
        TextView price = itemLayout.findViewById(R.id.txtSub);

        imageView.setImageResource(item.getImage());
        txtName.setText(item.getName());
        price.setText(item.getPrice());

        return itemLayout;
    }
}

