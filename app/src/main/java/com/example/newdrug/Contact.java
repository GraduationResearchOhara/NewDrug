package com.example.newdrug;

//連絡事項（ホームから遷移した先）
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // ボトムナビゲーションバーの初期設定
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // メニューアイテムのIDを取得

                if (itemId == R.id.navigation_chat) {
                    // チャット画面に遷移
                    Intent intent1 = new Intent(Contact.this, ChatActivity.class);
                    startActivity(intent1);
                    return true;
                } else if (itemId == R.id.navigation_book) {
                    // お薬手帳に遷移
                    Intent intent2 = new Intent(Contact.this, SelectMode.class);
                    startActivity(intent2);
                    return true;
                } else if (itemId == R.id.navigation_contact) {
                    // 連絡に遷移
                    Intent intent3 = new Intent(Contact.this, Contact.class);
                    startActivity(intent3);
                    return true;
                } else if (itemId == R.id.navigation_person) {
                    // 個人情報に遷移
                    Intent intent4 = new Intent(Contact.this, AccountManagementActivity.class);
                    startActivity(intent4);
                    return true;
                }
                else if (itemId == R.id.navigation_home) {
                    // Home画面に遷移
                    Intent intentHome = new Intent(Contact.this, Home.class);
                    startActivity(intentHome);
                    return true;
                }
                return false;
            }
        });

        // メールボタンの処理
        Button mailButton = findViewById(R.id.MailButton);
        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // メールに遷移
                Intent intent = new Intent(Contact.this, Mail.class);
                startActivity(intent);
            }
        });

//        // お知らせボタンの処理
        Button noticeButton = findViewById(R.id.NoticeButton);
        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // お知らせに遷移
                Intent intent = new Intent(Contact.this, Notice.class);
                startActivity(intent);
            }
        });
    }
}
