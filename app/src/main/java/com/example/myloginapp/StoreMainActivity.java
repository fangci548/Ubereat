package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StoreMainActivity extends AppCompatActivity {

	ListView listView;
	int index;
	ArrayList<StoreShopItem> arrayList = new ArrayList<>();
	StoreShopItemAdapter productAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_main);

		listView = findViewById(R.id.store_main_lv);

		arrayList.add(new StoreShopItem(R.drawable.mexico,"蛋餅","$30","好吃蛋餅"));
		arrayList.add(new StoreShopItem(R.drawable.food,"豬肉蛋堡","$50","肥美豬肉蛋堡"));
		arrayList.add(new StoreShopItem(R.drawable.mexico,"薯條","$40","酥炸薯條"));

		productAdapter = new StoreShopItemAdapter(this,R.layout.customer_shop,arrayList);

		listView.setAdapter(productAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				index = i;
				Intent intent = new Intent();
				intent.setClass(StoreMainActivity.this, StoreProductEdit.class);
				intent.putExtra("NAME", arrayList.get(i).Name);
				intent.putExtra("DES", arrayList.get(i).description);
				intent.putExtra("PRICE", arrayList.get(i).price);
				startActivityForResult(intent,i);

			}
		});
	}
}