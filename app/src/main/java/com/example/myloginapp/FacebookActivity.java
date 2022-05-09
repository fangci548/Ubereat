package com.example.myloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name;
    Button logOutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);

        imageView = findViewById(R.id.imageview);
        name = findViewById(R.id.name);
        logOutBtn = findViewById(R.id.logout);

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        GraphRequest request = GraphRequest.newMeRequest(
            accessToken,
            new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(
                        JSONObject object,
                        GraphResponse response) {
                    // Application code
                    try {
                        String fullName = object.getString("name");
                        String url = object.getJSONObject("picture").getJSONObject("data").getString("url");
                        name.setText(fullName);
                        Picasso.get().load(url).into(imageView);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,picture.type(large)");
        request.setParameters(parameters);
        request.executeAsync();

        logOutBtn.setOnClickListener(view -> {
            LoginManager.getInstance().logOut();
            startActivity(new Intent(FacebookActivity.this,MainActivity.class));
            finish();
        });
    }
}