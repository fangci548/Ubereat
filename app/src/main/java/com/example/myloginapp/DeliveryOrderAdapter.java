package com.example.myloginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DeliveryOrderAdapter extends ArrayAdapter<DeliveryOrderItem> {

    private Context context;
    private ArrayList<DeliveryOrderItem> products;

    public DeliveryOrderAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DeliveryOrderItem> products) {
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
            itemLayout = (LinearLayout) inflater.inflate(R.layout.deliver_order_list, null);
        } else {
            itemLayout = (LinearLayout) convertView;
        }

        DeliveryOrderItem item = products.get(position);

        TextView orderNumber = itemLayout.findViewById(R.id.order_number);
        orderNumber.setText(item.getOrderNumber());

        TextView orderShopName = itemLayout.findViewById(R.id.order_shopname);
        orderShopName.setText(item.getShopName());

        TextView orderFee = itemLayout.findViewById(R.id.order_deliverfee);
        orderFee.setText(item.getDeliveryFee());

        TextView orderDistance = itemLayout.findViewById(R.id.order_distance);
        orderDistance.setText(item.getDistance());

        return itemLayout;
    }
}
