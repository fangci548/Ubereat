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
import java.util.List;

public class StoreOrderItemAdapter extends ArrayAdapter<StoreOrderItem> {
  private Context context;
  private ArrayList<StoreOrderItem> orders;


  public StoreOrderItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<StoreOrderItem> orders) {
    super(context, resource, orders);
    this.context = context;
    this.orders = orders;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(this.context);
    LinearLayout itemLayout = null;

    if (convertView == null) {
      itemLayout = (LinearLayout) inflater.inflate(R.layout.store_main_layout, null);
    } else {
      itemLayout = (LinearLayout) convertView;
    }
    StoreOrderItem item = orders.get(position);

    TextView itemMark = itemLayout.findViewById(R.id.store_main_mark);
    TextView itemNum = itemLayout.findViewById(R.id.store_main_num);
    TextView itemTime = itemLayout.findViewById(R.id.store_main_time);

    itemMark.setText("#");
    itemNum.setText(item.getNum());
    itemTime.setText(item.getTime());

    return itemLayout;

  }
}
