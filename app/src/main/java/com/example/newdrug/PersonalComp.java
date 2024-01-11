package com.example.newdrug;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class PersonalComp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_comp);

        // ボトムナビゲーションバーの初期設定
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // メニューアイテムのIDを取得

                if (itemId == R.id.navigation_chat) {
                    // チャット画面に遷移
                    Intent intent1 = new Intent(PersonalComp.this, Chat.class);
                    startActivity(intent1);
                    return true;
                } else if (itemId == R.id.navigation_book) {
                    // お薬手帳に遷移
                    Intent intent2 = new Intent(PersonalComp.this, MainActivity.class);
                    startActivity(intent2);
                    return true;
                } else if (itemId == R.id.navigation_contact) {
                    // 連絡に遷移
                    Intent intent3 = new Intent(PersonalComp.this, Contact.class);
                    startActivity(intent3);
                    return true;
                } else if (itemId == R.id.navigation_person) {
                    // 個人情報に遷移
                    Intent intent4 = new Intent(PersonalComp.this, PersonalInformation.class);
                    startActivity(intent4);
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    // Home画面に遷移
                    Intent intentHome = new Intent(PersonalComp.this, Home.class);
                    startActivity(intentHome);
                    return true;
                }
                return false;
            }
        });

        Button confirmButton = findViewById(R.id.backButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 最終画面に遷移
                Intent intentInformation = new Intent(PersonalComp.this, PersonalInformation.class);
                startActivity(intentInformation);
            }
        });

    }
}