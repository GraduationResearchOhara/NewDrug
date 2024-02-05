package com.example.newdrug;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MailDetail extends AppCompatActivity {

    private ImageButton imageButton;

    public static final String EXTRA_MAIL_ITEM = "mail_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_detail);

        // ボトムナビゲーションバーの初期設定
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // メニューアイテムのIDを取得

                if (itemId == R.id.navigation_chat) {
                    // チャット画面に遷移
                    Intent intent1 = new Intent(MailDetail.this, ChatActivity.class);
                    startActivity(intent1);
                    return true;
                } else if (itemId == R.id.navigation_book) {
                    // お薬手帳に遷移
                    Intent intent2 = new Intent(MailDetail.this, SelectMode.class);
                    startActivity(intent2);
                    return true;
                } else if (itemId == R.id.navigation_contact) {
                    // 連絡に遷移
                    Intent intent3 = new Intent(MailDetail.this, Contact.class);
                    startActivity(intent3);
                    return true;
                } else if (itemId == R.id.navigation_person) {
                    // 個人情報に遷移
                    Intent intent4 = new Intent(MailDetail.this, AccountManagementActivity.class);
                    startActivity(intent4);
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    // Home画面に遷移
                    Intent intentHome = new Intent(MailDetail.this, Home.class);
                    startActivity(intentHome);
                    return true;
                }
                return false;
            }
        });

        // 選択したメールアイテムを受け取る
        MailItem mailItem = getIntent().getParcelableExtra(EXTRA_MAIL_ITEM);

        // メールの詳細情報を表示するUI要素にデータをセット
        TextView titleTextView = findViewById(R.id.titleTextView);
        imageButton = findViewById(R.id.ImageButton);
        TextView senderTextView = findViewById(R.id.senderTextView);
        TextView bodyTextView = findViewById(R.id.bodyTextView);
        TextView dateTextView = findViewById(R.id.dateTextView);

        titleTextView.setText(mailItem.getTitle());
        senderTextView.setText("From: " + mailItem.getSender());
        bodyTextView.setText(mailItem.getBody());
        dateTextView.setText("Date: " + mailItem.getDate());

        ImageButton backButton = findViewById(R.id.ImageButton); // R.id.backButtonはXMLで戻るボタンに割り当てたID
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 戻るボタンがクリックされたときの処理
                finish(); // アクティビティを終了して前の画面に戻る
            }
        });

    }
}
