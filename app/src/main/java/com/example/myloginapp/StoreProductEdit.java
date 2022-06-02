package com.example.myloginapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoreProductEdit extends AppCompatActivity {

	TextView tv_name;
	TextView tv_descrption;
	TextView tv_price;
	final int RESULT_DELETE = -3;

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

	public void onDelete(View v){
		AlertDialog.Builder alertDialog =
				new AlertDialog.Builder(StoreProductEdit.this);
		alertDialog.setTitle("刪除警告");
		alertDialog.setMessage("確定要刪除商品嗎？");
		alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				setResult(RESULT_DELETE);
				finish();
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

	}
}