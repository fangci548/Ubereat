package com.example.myloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class productAdapter extends ArrayAdapter<product> {
    private Context mContext;
    private int mResource;

    public productAdapter(@NonNull Context context, int resource, @NonNull ArrayList<product> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView price = convertView.findViewById(R.id.txtSub);

        imageView.setImageResource(getItem(position).getImage());
        txtName.setText(getItem(position).getName());
        price.setText(getItem(position).getPrice());

        return convertView;
    }
}

