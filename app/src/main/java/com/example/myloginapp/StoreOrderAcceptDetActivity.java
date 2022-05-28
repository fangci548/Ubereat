package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class StoreOrderAcceptDetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orderaccept_det);
    }

  public void onBack(View v) {

    setResult(RESULT_CANCELED);
    finish();
  }
}