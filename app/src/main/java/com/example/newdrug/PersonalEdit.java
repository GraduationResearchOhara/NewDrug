//個人情報編集

package com.example.newdrug;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PersonalEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_edit);

//        // ボトムナビゲーションバーの初期設定
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // メニューアイテムのIDを取得

                if (itemId == R.id.navigation_chat) {
                    // チャット画面に遷移
                    Intent intent1 = new Intent(PersonalEdit.this, Chat.class);
                    startActivity(intent1);
                    return true;
                } else if (itemId == R.id.navigation_book) {
                    // お薬手帳に遷移
                    Intent intent2 = new Intent(PersonalEdit.this, MainActivity.class);
                    startActivity(intent2);
                    return true;
                } else if (itemId == R.id.navigation_contact) {
                    // 連絡に遷移
                    Intent intent3 = new Intent(PersonalEdit.this, Contact.class);
                    startActivity(intent3);
                    return true;
                } else if (itemId == R.id.navigation_person) {
                    // 個人情報に遷移
                    Intent intent4 = new Intent(PersonalEdit.this, PersonalInformation.class);
                    startActivity(intent4);
                    return true;
                }
                else if (itemId == R.id.navigation_home) {
                    // Home画面に遷移
                    Intent intentHome = new Intent(PersonalEdit.this, Home.class);
                    startActivity(intentHome);
                    return true;
                }
                return false;
            }
        });

        // UI要素の取得
//        EditText idEditText = findViewById(R.id.ID);
//        EditText nameEditText = findViewById(R.id.textPersonName);
//        EditText dobEditText = findViewById(R.id.DateOfBirth);
        EditText emailEditText = findViewById(R.id.EmailAddress);
        EditText passwordEditText = findViewById(R.id.Password);
//        EditText medicineEditText = findViewById(R.id.medicine);
        Button nextButton = findViewById(R.id.nextButton);
        Button backButton = findViewById(R.id.backButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 確定画面に遷移
                Intent intentConf = new Intent(PersonalEdit.this, PersonalConf.class);
                startActivity(intentConf);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 確定画面に遷移
                Intent intentInformation = new Intent(PersonalEdit.this, PersonalInformation.class);
                startActivity(intentInformation);
            }
        });
    }
}