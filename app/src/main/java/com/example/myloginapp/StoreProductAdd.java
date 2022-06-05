package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoreProductAdd extends AppCompatActivity {

  TextView tv_name;
  TextView tv_price;
  TextView tv_descrp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_product_add);

    tv_name = findViewById(R.id.et_name);
    tv_price = findViewById(R.id.et_price);
    tv_descrp = findViewById(R.id.et_describe);

  }

  public void onSave(View v){
    Intent it2 = new Intent();
    it2.putExtra("NAME",tv_name.getText().toString());
    it2.putExtra("DES",tv_descrp.getText().toString());
    it2.putExtra("PRICE",tv_price.getText().toString());
    setResult(RESULT_OK,it2);
    finish();
  }

  public void onCancel(View v) {

    setResult(RESULT_CANCELED);
    finish();
  }

  public void onBack(View v) {

    setResult(RESULT_CANCELED);
    finish();
  }

}