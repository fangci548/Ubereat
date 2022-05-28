package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CustomItemDetailActivity extends AppCompatActivity {

    public static final String ALBUM_NO = "album_no";
    CheckBox mCB1;          //用於顯示選項
    CheckBox mCB2;
    CheckBox mCB3;
    CheckBox mCB4;
    CheckBox mCB5;
    Button mBT2;            //提交購物車按鈕

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_item_detail);
        initUI();           //初始化控制元件

        mCB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mCB1.isChecked())
                    MyToast("你選擇了："+mCB1.getText());
            }
        });

        mCB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mCB2.isChecked())
                    MyToast("你選擇了："+mCB2.getText());
            }
        });

        mCB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mCB3.isChecked())
                    MyToast("你選擇了："+mCB3.getText());
            }
        });

        mCB4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mCB4.isChecked())
                    MyToast("你選擇了："+mCB4.getText());
            }
        });
        mBT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast("加入購物車");
                Intent intent = new Intent();
                intent.setClass(CustomItemDetailActivity.this, CustomShopCartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void goToCart(View v){
        Intent intent = new Intent();
        intent.setClass(this, CustomShopCartActivity.class);
        startActivity(intent);
    }

    private void initUI() {
        mCB1 = (CheckBox)findViewById(R.id.checkBox1);
        mCB2 = (CheckBox)findViewById(R.id.checkBox2);
        mCB3 = (CheckBox)findViewById(R.id.checkBox3);
        mCB4 = (CheckBox)findViewById(R.id.checkBox4);
        mCB5 = (CheckBox)findViewById(R.id.checkBox5);
        mBT2 = (Button)findViewById(R.id.meal_check);
    }

    private void MyToast(String str) {
        Toast mtoast = Toast.makeText(CustomItemDetailActivity.this,str,Toast.LENGTH_SHORT);
        mtoast.setGravity(Gravity.TOP,0,800);
        mtoast.show();
    }
}