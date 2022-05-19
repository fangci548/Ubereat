package com.example.myloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] shopName;
    private int[] shopImage;

    public MainAdapter(Context context, String[] shopName, int[] shopImage) {
        this.context = context;
        this.shopName = shopName;
        this.shopImage = shopImage;
    }

    @Override
    public int getCount() {
        return shopImage.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_shop,null);
        }
        ImageView imageView = convertView.findViewById(R.id.iv_photo);
        TextView textView = convertView.findViewById(R.id.shop_name);

        imageView.setImageResource(shopImage[position]);
        textView.setText(shopName[position]);
        return convertView;
    }
}
