package com.example.newdrug;
//個人情報確認画面

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PersonalInformation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);

      // ボトムナビゲーションバーの初期設定
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // メニューアイテムのIDを取得

                if (itemId == R.id.navigation_chat) {
                    // チャット画面に遷移
                    Intent intent1 = new Intent(PersonalInformation.this, Chat.class);
                    startActivity(intent1);
                    return true;
                } else if (itemId == R.id.navigation_book) {
                    // お薬手帳に遷移
                    Intent intent2 = new Intent(PersonalInformation.this, MainActivity.class);
                    startActivity(intent2);
                    return true;
                } else if (itemId == R.id.navigation_contact) {
                    // 連絡に遷移
                    Intent intent3 = new Intent(PersonalInformation.this, Contact.class);
                    startActivity(intent3);
                    return true;
                } else if (itemId == R.id.navigation_person) {
                    // 個人情報に遷移
                    Intent intent4 = new Intent(PersonalInformation.this, PersonalInformation.class);
                    startActivity(intent4);
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    // Home画面に遷移
                    Intent intentHome = new Intent(PersonalInformation.this, Home.class);
                    startActivity(intentHome);
                    return true;
                }
                return false;
            }
        });

        Button editButton = findViewById(R.id.editButton);
        // 編集ボタンがクリックされたときの処理
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 編集画面に遷移
                Intent intentEdit = new Intent(PersonalInformation.this, PersonalEdit.class);
                startActivity(intentEdit);
            }
        });
    }
}
