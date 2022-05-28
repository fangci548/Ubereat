package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ManagerDeliverinfoActivity extends AppCompatActivity {


  TextView deliver_name;
  TextView deliver_id;
  ImageView deliver_img;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_manager_deliverinfo);

    deliver_name = findViewById(R.id.deliver_name);
    deliver_id = findViewById(R.id.deliver_id);
    deliver_img = findViewById(R.id.manage_deliverinfo_img);

    Intent intent = getIntent();
    deliver_name.setText(intent.getStringExtra("NAME"));
    deliver_id.setText(intent.getStringExtra("ID"));
    deliver_img.setImageResource(intent.getIntExtra("IMG",0));

  }

  public void onBack(View v) {

    setResult(RESULT_CANCELED);
    finish();
  }
}