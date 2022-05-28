package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class StoreProductActivity extends AppCompatActivity {

  ListView listView;
  int index;
  ArrayList<StoreShopItem> arrayList = new ArrayList<>();
  StoreShopItemAdapter productAdapter;
  final int ADD_REQUEST = 100;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_product);

    listView = findViewById(R.id.store_product_lv);



    arrayList.add(new StoreShopItem(R.drawable.maxico,"蛋餅","$30","好吃蛋餅"));
    arrayList.add(new StoreShopItem(R.drawable.food,"豬肉蛋堡","$50","肥美豬肉蛋堡"));
    arrayList.add(new StoreShopItem(R.drawable.maxico,"薯條","$40","酥炸薯條"));

    productAdapter = new StoreShopItemAdapter(this,R.layout.customer_shop,arrayList);

    listView.setAdapter(productAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        index = i;
        Intent intent = new Intent();
        intent.setClass(StoreProductActivity.this, StoreProductEdit.class);
        intent.putExtra("NAME", arrayList.get(i).Name);
        intent.putExtra("DES", arrayList.get(i).description);
        intent.putExtra("PRICE", arrayList.get(i).price);
        startActivityForResult(intent,i);

      }
    });

  }

  public void addProduct(View v){
    Intent intent = new Intent();
    intent.setClass(StoreProductActivity.this, StoreProductAdd.class);
    startActivityForResult(intent,ADD_REQUEST);

  }

  @Override
  protected void onActivityResult (int requestCode, int resultCode, Intent it){
    super.onActivityResult(requestCode, resultCode,it);

    if(requestCode == ADD_REQUEST){

      if(resultCode == RESULT_OK){
        String na = it.getStringExtra("NAME");
        String pr = it.getStringExtra("PRICE");
        String de = it.getStringExtra("DES");
        arrayList.add(new StoreShopItem(R.drawable.maxico,na,pr,de));
        productAdapter.notifyDataSetChanged();
      }
    }
    else{ //adit
      if(resultCode == RESULT_OK){
        String na = it.getStringExtra("NAME");
        String pr = it.getStringExtra("PRICE");
        String de = it.getStringExtra("DES");
        arrayList.get(index).setName(na);
        arrayList.get(index).setPrice(pr);
        arrayList.get(index).setDescription(de);
        productAdapter.notifyDataSetChanged();
      }
    }


  }



}

