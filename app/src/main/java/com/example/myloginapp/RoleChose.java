package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RoleChose extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.role_chose);
	}

	public void goToCustomer(View v){
		Intent intent = new Intent(this, LoginActivity.class);
		intent.putExtra("Role", "customer");
		startActivity(intent);
	}

	public void goToStore(View v){
		Intent intent = new Intent(this, LoginActivity.class);
		intent.putExtra("Role", "store");
		startActivity(intent);
	}

	public void goToDeliver(View v){
		Intent intent = new Intent(this, LoginActivity.class);
		intent.putExtra("Role", "deliver");
		startActivity(intent);
	}

  public void goToManager(View v){
    Intent intent = new Intent(this, LoginActivity.class);
    intent.putExtra("Role", "manager");
    startActivity(intent);
  }

}