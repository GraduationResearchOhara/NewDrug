package com.example.newdrug;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LoginComp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_comp);

        // 画面遷移を行うためのIntentの作成
        findViewById(R.id.homeBackButton).setOnClickListener(v -> {
            Intent intent = new Intent(LoginComp.this, Home.class);
            startActivity(intent); // SecondActivityに遷移
        });

    }
}