package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ManagerMemberinfoActivity extends AppCompatActivity {

  TextView member_name;
  TextView member_id;
  ImageView member_img;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_manager_memberinfo);

    member_name = findViewById(R.id.member_name);
    member_id = findViewById(R.id.member_id);
    member_img = findViewById(R.id.manage_memberinfo_img);

    Intent intent = getIntent();
    member_name.setText(intent.getStringExtra("NAME"));
    member_id.setText(intent.getStringExtra("ID"));
    member_img.setImageResource(intent.getIntExtra("IMG",0));


  }

  public void onBack(View v) {

    setResult(RESULT_CANCELED);
    finish();
  }
}