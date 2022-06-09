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

public class OrderDetItemAdapter extends ArrayAdapter<OrderDetailItem> {
  private Context context;
  private ArrayList<OrderDetailItem> orderdetail;

  public OrderDetItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<OrderDetailItem> orderdetail) {
    super(context, resource, orderdetail);
    this.context = context;
    this.orderdetail = orderdetail;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(this.context);
    LinearLayout itemLayout = null;

    if (convertView == null) {
      itemLayout = (LinearLayout) inflater.inflate(R.layout.store_orderdetail_layout, null);
    } else {
      itemLayout = (LinearLayout) convertView;
    }

    OrderDetailItem item = orderdetail.get(position);

    TextView itemValue = itemLayout.findViewById(R.id.product_id);
    TextView itemName = itemLayout.findViewById(R.id.product_name);
    TextView itemNum = itemLayout.findViewById(R.id.product_num);
    TextView itemPrice = itemLayout.findViewById(R.id.product_price);

    itemName.setText(item.getName());
    itemValue.setText(item.getValue());
    itemNum.setText(item.getNum());
    itemPrice.setText("$" + item.getPrice());

    return itemLayout;  }
}
