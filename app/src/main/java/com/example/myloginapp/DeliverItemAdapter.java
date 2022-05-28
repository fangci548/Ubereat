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

public class DeliverItemAdapter extends ArrayAdapter<DeliverItem> {
  private Context context;
  private ArrayList<DeliverItem> delivers;

  public DeliverItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DeliverItem> delivers) {
    super(context, resource, delivers);
    this.context = context;
    this.delivers = delivers;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(this.context);
    LinearLayout itemLayout = null;

    if (convertView == null) {
      itemLayout = (LinearLayout) inflater.inflate(R.layout.manager_manage_member_layout, null);
    } else {
      itemLayout = (LinearLayout) convertView;
    }

    DeliverItem item = delivers.get(position);

    ImageView imageView = itemLayout.findViewById(R.id.img);
    TextView itemName = itemLayout.findViewById(R.id.name);
    TextView itemId = itemLayout.findViewById(R.id.id);

    imageView.setImageResource(item.getImg());
    itemName.setText(item.getName());
    itemId.setText(item.getId());

    return itemLayout;
  }
}
