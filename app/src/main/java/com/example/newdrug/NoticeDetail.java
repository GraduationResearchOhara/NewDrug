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

public class NoticeDetail extends AppCompatActivity {

    private ImageButton imageButton;

    public static final String EXTRA_NOTICE_ITEM = "notice_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        // ボトムナビゲーションバーの初期設定
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // メニューアイテムのIDを取得

                if (itemId == R.id.navigation_chat) {
                    // チャット画面に遷移
                    Intent intent1 = new Intent(NoticeDetail.this, ChatActivity.class);
                    startActivity(intent1);
                    return true;
                } else if (itemId == R.id.navigation_book) {
                    // お薬手帳に遷移
                    Intent intent2 = new Intent(NoticeDetail.this, SelectMode.class);
                    startActivity(intent2);
                    return true;
                } else if (itemId == R.id.navigation_contact) {
                    // 連絡に遷移
                    Intent intent3 = new Intent(NoticeDetail.this, Contact.class);
                    startActivity(intent3);
                    return true;
                } else if (itemId == R.id.navigation_person) {
                    // 個人情報に遷移
                    Intent intent4 = new Intent(NoticeDetail.this, AccountManagementActivity.class);
                    startActivity(intent4);
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    // Home画面に遷移
                    Intent intentHome = new Intent(NoticeDetail.this, Home.class);
                    startActivity(intentHome);
                    return true;
                }
                return false;
            }
        });

        // 選択したお知らせアイテムを受け取る
        NoticeItem noticeItem = getIntent().getParcelableExtra(EXTRA_NOTICE_ITEM);

        // お知らせの詳細情報を表示するUI要素にデータをセット
        TextView titleTextView = findViewById(R.id.titleTextView);
        imageButton = findViewById(R.id.ImageButton);
        TextView contentTextView = findViewById(R.id.contentTextView);
        TextView dateTextView = findViewById(R.id.dateTextView);

        titleTextView.setText(noticeItem.getTitle());
        contentTextView.setText(noticeItem.getContent());
        dateTextView.setText("日付: " + noticeItem.getDate());

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
