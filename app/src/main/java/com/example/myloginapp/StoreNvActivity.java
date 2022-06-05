package com.example.myloginapp;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationBarView;

public class StoreNvActivity extends AppCompatActivity {


  private ConstraintLayout constraintLayout;
  private BottomNavigationView bottomNavigationView;
  StorehomeFragment homeFragment = new StorehomeFragment();
  StoreproductFragment productFragment = new StoreproductFragment();
  StoreaccountFragment accountFragment = new StoreaccountFragment();
  int bottomId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_nv);

    constraintLayout = findViewById(R.id.store_main);
    bottomNavigationView = findViewById(R.id.nav_view);
    bottomNavigationView.getMenu().getItem(0).setChecked(false);
    getSupportFragmentManager().beginTransaction().replace(R.id.store_frame, productFragment).commit();

    bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
          case R.id.product:
            bottomId = R.id.product;
            getSupportFragmentManager().beginTransaction().replace(R.id.store_frame, productFragment).commit();
            break;
          case R.id.frontpage:
            bottomId = R.id.frontpage;
            getSupportFragmentManager().beginTransaction().replace(R.id.store_frame, homeFragment).commit();
            break;
          case R.id.account:
            bottomId = R.id.account;
            getSupportFragmentManager().beginTransaction().replace(R.id.store_frame, accountFragment).commit();
            break;
        }
        return true;
      }
    });
  }


}