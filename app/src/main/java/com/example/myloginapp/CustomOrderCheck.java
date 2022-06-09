package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomOrderCheck extends AppCompatActivity {

    ListView listView;
    Spinner payMethod;

    ArrayList<CustomShopCartItem> arrayList = new ArrayList<>();
    TextView subtotalPrice; //小計
    TextView deliverPrice;//外送費
    TextView totalPrice; //總計
    private final static String DB_NAME = "UberEat";
    private final static String TABLE_NAME = "cart";
    private SQLiteDatabase myDatabase;
    private Cursor cursor;
    String price_meal , price_del , price_total;
    int PriceTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_order_check);

        myDatabase = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);

        String createDbSql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "STORENAME VARCHAR(30),"+
                "MEALNAME VARCHAR(30),"+
                "PRICE VARCHAR(16),"+
                "EXTRA VARCHAR(100) )";
        myDatabase.execSQL(createDbSql);
        String querySQL = "SELECT * FROM " + TABLE_NAME;
        cursor = myDatabase.rawQuery(querySQL, null);


        Intent intent = getIntent();
        listView = findViewById(R.id.customer_order_lv);
        subtotalPrice = findViewById(R.id.subTotal);
        deliverPrice = findViewById(R.id.deliveryFee);
        totalPrice = findViewById(R.id.totalPay);
        payMethod = findViewById(R.id.pay_spinner);

        String Name = intent.getStringExtra("MEAL_NAME");
        String Extra = intent.getStringExtra("MEAL_EXTRA");
        String Price = intent.getStringExtra("MEAL_PRICE");
        String storeName = intent.getStringExtra("STORE_NAME");
        price_del = intent.getStringExtra("DEL_PRICE");
        String[] pay = getResources().getStringArray(R.array.pay_method);
        int index = payMethod.getSelectedItemPosition();
        //deliverPrice.setText(price_del);

//        ContentValues v1 = addMeal(storeName,Name,Price,Extra);
//
//        myDatabase.insert(TABLE_NAME, null, v1);

        if(cursor.moveToFirst()){
            do{
                arrayList.add(new CustomShopCartItem(cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            }while (cursor.moveToNext());
        }
        CustomShopCartAdapter adapter = new CustomShopCartAdapter(this ,R.layout.customer_shop_cart_list,arrayList);

        listView.setAdapter(adapter);
    }
//
//    private ContentValues addMeal(String storeName,String mealName, String price, String extra){
//        ContentValues value = new ContentValues();
//        value.put("STORENAME",storeName);
//        value.put("MEALNAME", mealName);
//        value.put("PRICE", price);
//        value.put("EXTRA", extra);
//        return value;
//    }

    public void onBack(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }
}