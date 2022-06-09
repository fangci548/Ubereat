package com.example.myloginapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomShopCartActivity extends AppCompatActivity {


    ListView listView;

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
        setContentView(R.layout.customer_shop_cart);

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

        arrayList.clear();
        Intent intent = getIntent();
        listView = findViewById(R.id.shop_cart_lv);
        subtotalPrice = findViewById(R.id.subTotal);
        deliverPrice = findViewById(R.id.deliveryFee);
        totalPrice = findViewById(R.id.totalPay);

        String Name = intent.getStringExtra("MEAL_NAME");
        String Extra = intent.getStringExtra("MEAL_EXTRA");
        String Price = intent.getStringExtra("MEAL_PRICE");
        String storeName = intent.getStringExtra("STORE_NAME");
        price_del = intent.getStringExtra("DEL_PRICE");
        deliverPrice.setText(price_del);

        if(!Name.equals("")){
            ContentValues v1 = addMeal(storeName,Name,Price,Extra);
            myDatabase.insert(TABLE_NAME, null, v1);
        }


        if(cursor.moveToFirst()){
            do{
                arrayList.add(new CustomShopCartItem(cursor.getString(2),cursor.getString(3),cursor.getString(4)));
            }while (cursor.moveToNext());
        }
        CustomShopCartAdapter adapter = new CustomShopCartAdapter(CustomShopCartActivity.this ,R.layout.customer_shop_cart_list,arrayList);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder alertDialog =
                    new AlertDialog.Builder(CustomShopCartActivity.this);
                alertDialog.setTitle("刪除警告");
                alertDialog.setMessage("確定要刪除商品嗎？");
                alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        adapter.notifyDataSetChanged();
                        myDatabase.delete(TABLE_NAME,"mealname='" + arrayList.get(i).itemName + "'",null);
                        arrayList.remove(i);
                    }
                });
                alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.setCancelable(false);
                alertDialog.show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(CustomShopCartActivity.this, CustomItemDetailActivity.class);
                intent.putExtra("MEAL_NAME", arrayList.get(i).itemName);
                intent.putExtra("MEAL_PRICE", arrayList.get(i).itemPrice);
                intent.putExtra("DEL_PRICE", arrayList.get(i).itemExtra);
                startActivity(intent);
            }
        });
    }

    private ContentValues addMeal(String storeName,String mealName, String price, String extra){
        ContentValues value = new ContentValues();

        value.put("STORENAME",storeName);
        value.put("MEALNAME", mealName);
        value.put("PRICE", price);
        value.put("EXTRA", extra);
        return value;
    }

    public void goToOrder(View v){
        Intent intent = new Intent();
        intent.setClass(this, CustomOrderCheck.class);
        startActivity(intent);
    }


    public void keepShop(View v){
        finish();
    }

}