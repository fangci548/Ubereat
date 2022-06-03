package com.example.myloginapp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.myloginapp.R;
import com.example.myloginapp.databinding.FragmentStoreHomeBinding;

import java.util.ArrayList;

public class StorehomeFragment extends Fragment {

  ListView listView;
  int index;
  ArrayList<StoreOrderItem> arrayList1 = new ArrayList<>();
  ArrayList<StoreOrderItem> arrayList2 = new ArrayList<>();
  ArrayList<StoreOrderItem> arrayList3 = new ArrayList<>();
  StoreOrderItemAdapter orderAdapter;
  int opt = 1;
  Context context;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    context = container.getContext();
    View view = inflater.inflate(R.layout.fragment_store_home, container, false);
    listView = view.findViewById(R.id.store_main_lv);

    arrayList1.add(new StoreOrderItem("#","358678","2022/02/30 13:00"));
    arrayList1.add(new StoreOrderItem("#", "123456","2022/01/31 14:00"));
    arrayList1.add(new StoreOrderItem("#","543256","2022/05/01 17:00"));

    arrayList2.add(new StoreOrderItem("#","222222","2022/02/30 13:00"));
    arrayList2.add(new StoreOrderItem("#", "333333","2022/01/31 14:00"));
    arrayList2.add(new StoreOrderItem("#","444444","2022/05/01 17:00"));

    arrayList3.add(new StoreOrderItem("#","777777","2022/02/30 13:00"));
    arrayList3.add(new StoreOrderItem("#", "685432","2022/01/31 14:00"));
    arrayList3.add(new StoreOrderItem("#","234567","2022/05/01 17:00"));

    orderAdapter = new StoreOrderItemAdapter(context,R.layout.store_main_layout,arrayList1);
    listView.setAdapter(orderAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        index = i;
        Intent intent = new Intent();
        intent.setClass(context, StoreOrderAcceptDetActivity.class);
        if(opt == 1) {
          intent.setClass(context, StoreWaitOrderDetActivity.class);
          intent.setClass(context, StoreWaitOrderDetActivity.class);
          intent.putExtra("Mark", arrayList1.get(i).mark);
          intent.putExtra("Num", arrayList1.get(i).num);
          intent.putExtra("tTime", arrayList1.get(i).time);
        } else if(opt == 2) {
          intent.setClass(context, StoreOrderAcceptDetActivity.class);
          intent.setClass(context, StoreOrderAcceptDetActivity.class);
          intent.putExtra("Mark", arrayList2.get(i).mark);
          intent.putExtra("Num", arrayList2.get(i).num);
          intent.putExtra("tTime", arrayList2.get(i).time);
        } else if(opt == 3) {
          intent.setClass(context, StoreOrderCompleteDetActivity.class);
          intent.setClass(context, StoreOrderCompleteDetActivity.class);
          intent.putExtra("Mark", arrayList3.get(i).mark);
          intent.putExtra("Num", arrayList3.get(i).num);
          intent.putExtra("tTime", arrayList3.get(i).time);
        }

        startActivityForResult(intent,i);

      }
    });

    Button button1 = (Button) view.findViewById(R.id.waitbottom);
    Button button2 = (Button) view.findViewById(R.id.acceptbottom);
    Button button3 = (Button) view.findViewById(R.id.combottom);

    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        opt = 1;
        orderAdapter = new StoreOrderItemAdapter(context,R.layout.store_main_layout,arrayList1);
        listView.setAdapter(orderAdapter);
      }
    });
    button2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        opt = 2;
        orderAdapter = new StoreOrderItemAdapter(context,R.layout.store_main_layout,arrayList2);
        listView.setAdapter(orderAdapter);
      }
    });

    button3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        opt = 3;
        orderAdapter = new StoreOrderItemAdapter(context,R.layout.store_main_layout,arrayList3);
        listView.setAdapter(orderAdapter);
      }
    });

    return view;
  }

}
