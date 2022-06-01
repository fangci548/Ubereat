package com.example.myloginapp;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

public class CustomShopCartAdapter implements ListAdapter {
    private Context context;
    private String[] itemName;
    private String[] itemPrice;
    private LayoutInflater inflater;

    public CustomShopCartAdapter(Context context, String[] itemName, String[] itemPrice) {
        this.context = context;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
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
    public boolean hasStableIds() {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.customer_shop,null);
        }
        TextView itemname = convertView.findViewById(R.id.itemName);
        TextView itemprice = convertView.findViewById(R.id.itemPrice);

        itemname.setText(itemName[position]);
        itemprice.setText(itemPrice[position]);
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
