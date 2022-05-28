package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoreProductEdit extends AppCompatActivity {

	TextView tv_name;
	TextView tv_descrption;
	TextView tv_price;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_product_edit);

		tv_name = findViewById(R.id.et_name);
		tv_descrption = findViewById(R.id.et_describe);
		tv_price = findViewById(R.id.et_price);

		Intent intent = getIntent();
		tv_name.setText(intent.getStringExtra("NAME"));
		tv_descrption.setText(intent.getStringExtra("DES"));
		tv_price.setText(intent.getStringExtra("PRICE"));
	}

	public void onCancel(View v){
		setResult(RESULT_CANCELED);
		finish();
	}

	public void onSave(View v){
		Intent it2 = new Intent();
		it2.putExtra("NAME",tv_name.getText().toString());
		it2.putExtra("DES",tv_descrption.getText().toString());
		it2.putExtra("PRICE",tv_price.getText().toString());
		setResult(RESULT_OK,it2);
		finish();
	}

  public void onBack(View v) {

    setResult(RESULT_CANCELED);
    finish();
  }
}