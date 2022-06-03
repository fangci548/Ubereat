package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class StoreproductFragment extends AppCompatActivity {

  ListView listView;
  int index;
  int index_array;
  ArrayList<StoreShopItem> arrayList = new ArrayList<>();
  StoreShopItemAdapter productAdapter;
  final int ADD_REQUEST = 100;
  final int RESULT_DELETE = -3;
  private final static String DB_NAME = "UberEat";
  private final static String TABLE_NAME = "product";
  private SQLiteDatabase myDatabase;
  private Cursor cursor;
  private String old_name;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_product);

    listView = findViewById(R.id.store_product_lv);

    myDatabase = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
    String createDbSql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "NAME VARCHAR(30),"+
            "PRICE VARCHAR(16),"+
            "DES VARCHAR(100) )"; // 還有一個photo
    myDatabase.execSQL(createDbSql);
    String querySQL = "SELECT * FROM " + TABLE_NAME;
    cursor = myDatabase.rawQuery(querySQL, null);

    if(cursor.getCount() == 0){
      ContentValues v1 = addFriend("蛋餅","30","好吃蛋餅");
      ContentValues v2 = addFriend("豬肉蛋堡","50","肥美豬肉蛋堡");
      ContentValues v3 = addFriend("薯條","40","酥炸薯條");
      myDatabase.insert(TABLE_NAME, null, v1);
      myDatabase.insert(TABLE_NAME, null, v2);
      myDatabase.insert(TABLE_NAME, null, v3);
      //listView.setAdapter(myDatabase.getPath() + "\n" + myDatabase.getPageSize());
      myDatabase.close();
    }

//    arrayList.add(new StoreShopItem(R.drawable.mexico,"蛋餅","30","好吃蛋餅"));
//    arrayList.add(new StoreShopItem(R.drawable.food,"豬肉蛋堡","50","肥美豬肉蛋堡"));
//    arrayList.add(new StoreShopItem(R.drawable.mexico,"薯條","40","酥炸薯條"));
    if(cursor.moveToFirst()){
      do{

        arrayList.add(new StoreShopItem(R.drawable.mexico,cursor.getString(1),cursor.getString(2),cursor.getString(3)));
//        arrayList.add(new StoreShopItem(R.drawable.food,cursor.getString(0),"50","肥美豬肉蛋堡"));
//        arrayList.add(new StoreShopItem(R.drawable.mexico,"薯條","40","酥炸薯條"));

      }while (cursor.moveToNext());
    }

    productAdapter = new StoreShopItemAdapter(this,R.layout.store_product_layout,arrayList);

    listView.setAdapter(productAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        index_array = i;
        old_name = arrayList.get(i).Name;
//        Cursor c = myDatabase.query(TABLE_NAME, null, "name='" + name + "'", null, null, null, null, null);

        Intent intent = new Intent();
        intent.setClass(StoreproductFragment.this, StoreProductEdit.class);
        intent.putExtra("NAME", arrayList.get(i).Name);
        intent.putExtra("DES", arrayList.get(i).description);
        intent.putExtra("PRICE", arrayList.get(i).price);
        startActivityForResult(intent,i);

      }
    });

  }

  private ContentValues addFriend(String name, String price, String des){
    ContentValues value = new ContentValues();
    value.put("NAME", name);
    value.put("PRICE", price);
    value.put("DES", des);
    return value;
  }

  public void addProduct(View v){
    Intent intent = new Intent();
    intent.setClass(StoreproductFragment.this, StoreProductAdd.class);
    startActivityForResult(intent,ADD_REQUEST);

  }

  @Override
  protected void onActivityResult (int requestCode, int resultCode, Intent it){
    super.onActivityResult(requestCode, resultCode,it);

    if(requestCode == ADD_REQUEST){//add

      if(resultCode == RESULT_OK){
        String na = it.getStringExtra("NAME");
        String pr = it.getStringExtra("PRICE");
        String de = it.getStringExtra("DES");
        ContentValues v1 = addFriend(na,pr,de);
        myDatabase.insert(TABLE_NAME, null, v1);
        //arrayList.add(new StoreShopItem(R.drawable.mexico,na,pr,de));

        arrayList.add(new StoreShopItem(R.drawable.mexico,na,pr,de));
        productAdapter.notifyDataSetChanged();


      }
    }
    else{ //edit&delete
      if(resultCode == RESULT_OK){ //edit
        String na = it.getStringExtra("NAME");
        String pr = it.getStringExtra("PRICE");
        String de = it.getStringExtra("DES");
//        arrayList.get(index).setName(na);
//        arrayList.get(index).setPrice("$" + pr);
//        arrayList.get(index).setDescription(de);
        ContentValues v1 = addFriend(na,pr,de);
        myDatabase.update(TABLE_NAME,v1,"name='" + old_name + "'",null);

        arrayList.get(index_array).Name = na;
        arrayList.get(index_array).description = de;
        arrayList.get(index_array).price = pr;
        productAdapter.notifyDataSetChanged();
      }
      else if(resultCode == RESULT_DELETE){
        arrayList.remove(index_array);
        productAdapter.notifyDataSetChanged();
        myDatabase.delete(TABLE_NAME,"name='" + old_name + "'",null);
      }
    }


  }



}