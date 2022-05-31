package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StoreComOrderActivity extends AppCompatActivity {

	ListView listView;
	int index;
	ArrayList<StoreOrderItem> arrayList1 = new ArrayList<>();
  ArrayList<StoreOrderItem> arrayList2 = new ArrayList<>();
  ArrayList<StoreOrderItem> arrayList3 = new ArrayList<>();
	StoreOrderItemAdapter orderAdapter;
  int opt = 1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_com_order);

		listView = findViewById(R.id.store_main_lv);

		arrayList1.add(new StoreOrderItem("#","358678","2022/02/30 13:00"));
		arrayList1.add(new StoreOrderItem("#", "123456","2022/01/31 14:00"));
		arrayList1.add(new StoreOrderItem("#","543256","2022/05/01 17:00"));

    arrayList2.add(new StoreOrderItem("#","222222","2022/02/30 13:00"));
    arrayList2.add(new StoreOrderItem("#", "333333","2022/01/31 14:00"));
    arrayList2.add(new StoreOrderItem("#","444444","2022/05/01 17:00"));

    arrayList3.add(new StoreOrderItem("#","777777","2022/02/30 13:00"));
    arrayList3.add(new StoreOrderItem("#", "685432","2022/01/31 14:00"));
    arrayList3.add(new StoreOrderItem("#","234567","2022/05/01 17:00"));

    orderAdapter = new StoreOrderItemAdapter(this,R.layout.store_main_layout,arrayList1);
    listView.setAdapter(orderAdapter);




		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				index = i;
				Intent intent = new Intent();
        intent.setClass(StoreComOrderActivity.this, StoreOrderAcceptDetActivity.class);
        if(opt == 1) {
          intent.setClass(StoreComOrderActivity.this, StoreWaitOrderDetActivity.class);
          intent.setClass(StoreComOrderActivity.this, StoreWaitOrderDetActivity.class);
          intent.putExtra("Mark", arrayList1.get(i).mark);
          intent.putExtra("Num", arrayList1.get(i).num);
          intent.putExtra("tTime", arrayList1.get(i).time);
        } else if(opt == 2) {
          intent.setClass(StoreComOrderActivity.this, StoreOrderAcceptDetActivity.class);
          intent.setClass(StoreComOrderActivity.this, StoreOrderAcceptDetActivity.class);
          intent.putExtra("Mark", arrayList2.get(i).mark);
          intent.putExtra("Num", arrayList2.get(i).num);
          intent.putExtra("tTime", arrayList2.get(i).time);
        } else if(opt == 3) {
          intent.setClass(StoreComOrderActivity.this, StoreOrderCompleteDetActivity.class);
          intent.setClass(StoreComOrderActivity.this, StoreOrderCompleteDetActivity.class);
          intent.putExtra("Mark", arrayList3.get(i).mark);
          intent.putExtra("Num", arrayList3.get(i).num);
          intent.putExtra("tTime", arrayList3.get(i).time);
        }

				startActivityForResult(intent,i);

			}
		});
	}

  public void onOption1(View v) {
    opt = 1;
    orderAdapter = new StoreOrderItemAdapter(this,R.layout.store_main_layout,arrayList1);
    listView.setAdapter(orderAdapter);
  }
  public void onOption2(View v) {
    opt = 2;
    orderAdapter = new StoreOrderItemAdapter(this,R.layout.store_main_layout,arrayList2);
    listView.setAdapter(orderAdapter);
  }
  public void onOption3(View v) {
    opt = 3;
    orderAdapter = new StoreOrderItemAdapter(this,R.layout.store_main_layout,arrayList3);
    listView.setAdapter(orderAdapter);
  }
}