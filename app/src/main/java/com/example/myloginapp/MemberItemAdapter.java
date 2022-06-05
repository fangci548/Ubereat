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

public class MemberItemAdapter extends ArrayAdapter<MemberItem> {

  private Context context;
  private ArrayList<MemberItem> members;

  public MemberItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MemberItem> members) {
    super(context, resource, members);
    this.context = context;
    this.members = members;
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

    MemberItem item = members.get(position);

    ImageView imageView = itemLayout.findViewById(R.id.img);
    TextView itemName = itemLayout.findViewById(R.id.name);
    TextView itemId = itemLayout.findViewById(R.id.id);

    imageView.setImageResource(item.getImg());
    itemName.setText(item.getName());
    itemId.setText(item.getId());

    return itemLayout;
    //return super.getView(position, convertView, parent);
  }
}
