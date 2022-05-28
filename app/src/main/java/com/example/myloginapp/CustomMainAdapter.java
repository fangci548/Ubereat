package com.example.myloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomMainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] shopName;
    private int[] shopImage;
    private String[] fee;
    private String[] time;
    private String[] shopStar;


    public CustomMainAdapter(Context context, String[] shopName, int[] shopImage, String[] fee, String[] time, String[] star) {
        this.context = context;
        this.shopName = shopName;
        this.shopImage = shopImage;
        this.fee = fee;
        this.time = time;
        this.shopStar = star;
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
            convertView = inflater.inflate(R.layout.customer_shop,null);
        }
        ImageView imageView = convertView.findViewById(R.id.iv_photo);
        TextView shop_name = convertView.findViewById(R.id.shop_name);
        TextView shop_fee = convertView.findViewById(R.id.delivery_fee);
        TextView shop_time = convertView.findViewById(R.id.delivery_time);
        TextView shop_star = convertView.findViewById(R.id.shop_star);


        imageView.setImageResource(shopImage[position]);
        shop_name.setText(shopName[position]);
        shop_fee.setText(fee[position]);
        shop_time.setText(time[position]);
        shop_star.setText(shopStar[position]);
        return convertView;
    }
}
