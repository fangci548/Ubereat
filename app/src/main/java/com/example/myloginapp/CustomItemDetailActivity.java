package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomItemDetailActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    String mealName;
    String mealPrice;
    String mealExtra = "";
    String storeName;
    String delPrice;
    String[] Extra_Fries = {"玫瑰鹽","胡椒鹽","甘梅粉"};
    String[] Extra_Ham = {"不需加醬","起司加量","蔬菜加量","醬料加量"};
    String[] Extra_EggCake = {"熱狗","玉米","起司","火腿","鮪魚肉鬆"};

    ArrayList<CompoundButton> selected_Extra = new ArrayList<>();
//    CheckBox mCB1;          //用於顯示選項
//    CheckBox mCB2;
//    CheckBox mCB3;
//    CheckBox mCB4;
//    CheckBox mCB5;
    int[] chk_id = {R.id.checkBox1,R.id.checkBox2,R.id.checkBox3,R.id.checkBox4,R.id.checkBox5};
    Button mBT2;            //提交購物車按鈕

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_item_detail);

        Intent intent = getIntent();
        mealName = intent.getStringExtra("MEAL_NAME");
        mealPrice = intent.getStringExtra("MEAL_PRICE");
        delPrice = intent.getStringExtra("DEL_PRICE");
        storeName = intent.getStringExtra("STORE_NAME");
        TextView tv_name = findViewById(R.id.item_name);
        TextView tv_price = findViewById(R.id.item_price);
        tv_price.setText(mealPrice);
        tv_name.setText(mealName);

//        initUI();           //初始化控制元件
        mBT2 = findViewById(R.id.meal_check);
        int i = 0;
        for(int id:chk_id){
            Log.v("fires", String.valueOf(id));
            CheckBox chk = (CheckBox) findViewById(id);
            if(mealName.equals("薯條") && i < Extra_Fries.length){
                chk.setText(Extra_Fries[i]);
                i++;
            }
            else if(mealName.equals("漢堡") && i < Extra_Ham.length){
                chk.setText(Extra_Ham[i]);
                i++;
            }
            else if(mealName.equals("蛋餅") && i < Extra_EggCake.length){
                chk.setText(Extra_EggCake[i]);
                i++;
            }
            else{
                chk.setVisibility(View.INVISIBLE);
            }

            chk.setOnCheckedChangeListener(this);
        }


//        mCB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(mCB1.isChecked())
//                    MyToast("你選擇了："+mCB1.getText());
//            }
//        });
//
//        mCB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(mCB2.isChecked())
//                    MyToast("你選擇了："+mCB2.getText());
//            }
//        });
//
//        mCB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(mCB3.isChecked())
//                    MyToast("你選擇了："+mCB3.getText());
//            }
//        });
//
//        mCB4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(mCB4.isChecked())
//                    MyToast("你選擇了："+mCB4.getText());
//            }
//        });

    }
//    public void onClick(View v) {
//
//        Intent intent = new Intent();
//        intent.setClass(CustomItemDetailActivity.this, CustomShopCartActivity.class);
//        startActivity(intent);
//        finish();
//    }
    public void goToCart(View v){
        MyToast("加入購物車");
        int lastIdx = selected_Extra.size() - 1;
        for(CompoundButton chk:selected_Extra){
            if(selected_Extra.get(lastIdx) == chk){
                mealExtra += chk.getText();
            }
            else{
                mealExtra += chk.getText() + ",";
            }
        }
        MyToast(mealExtra);
        Intent intent = new Intent();
        intent.setClass(this, CustomShopCartActivity.class);
        intent.putExtra("MEAL_NAME",mealName);
        intent.putExtra("MEAL_EXTRA",mealExtra);
        intent.putExtra("MEAL_PRICE",mealPrice);
        intent.putExtra("DEL_PRICE", delPrice);
        intent.putExtra("STORE_NAME",storeName);
        finish();
        startActivity(intent);
    }

//    private void initUI() {
//        mCB1 = (CheckBox)findViewById(R.id.checkBox1);
//        mCB2 = (CheckBox)findViewById(R.id.checkBox2);
//        mCB3 = (CheckBox)findViewById(R.id.checkBox3);
//        mCB4 = (CheckBox)findViewById(R.id.checkBox4);
//        mCB5 = (CheckBox)findViewById(R.id.checkBox5);
//        mBT2 = (Button)findViewById(R.id.meal_check);
//    }

    private void MyToast(String str) {
        Toast mtoast = Toast.makeText(CustomItemDetailActivity.this,str,Toast.LENGTH_SHORT);
        mtoast.setGravity(Gravity.TOP,0,800);
        mtoast.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if(checked){
            selected_Extra.add(compoundButton);
            MyToast("你選擇了："+compoundButton.getText());
        }
        else{
            selected_Extra.remove(compoundButton);
            MyToast("你取消選擇了："+compoundButton.getText());
        }
    }
}