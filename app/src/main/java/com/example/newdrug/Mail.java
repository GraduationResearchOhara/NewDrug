package com.example.newdrug;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Mail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // メニューアイテムのIDを取得

                if (itemId == R.id.navigation_chat) {
                    // チャット画面に遷移
                    Intent intent1 = new Intent(Mail.this, Chat.class);
                    startActivity(intent1);
                    return true;
                } else if (itemId == R.id.navigation_book) {
                    // お薬手帳に遷移
                    Intent intent2 = new Intent(Mail.this, MainActivity.class);
                    startActivity(intent2);
                    return true;
                } else if (itemId == R.id.navigation_contact) {
                    // 連絡に遷移
                    Intent intent3 = new Intent(Mail.this, Contact.class);
                    startActivity(intent3);
                    return true;
                } else if (itemId == R.id.navigation_person) {
                    // 個人情報に遷移
                    Intent intent4 = new Intent(Mail.this, PersonalInformation.class);
                    startActivity(intent4);
                    return true;
                }else if (itemId == R.id.navigation_home) {
                    // homeに遷移
                    Intent intent5 = new Intent(Mail.this, Home.class);
                    startActivity(intent5);
                    return true;
                }
                return false;
            }
        });

        // ダミーメールデータを取得する
        List<MailItem> mailItems = getMailData();

        // メールアイテムを表示するためのアダプターを作成
        ArrayAdapter<MailItem> mailAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mailItems);

        // リストビューのIDを取得
        ListView mailListView = findViewById(R.id.mailListView);

        // リストビューにアダプターをセット
        mailListView.setAdapter(mailAdapter);

        // メールアイテムがタップされたときのリスナーを設定
        mailListView.setOnItemClickListener((parent, view, position, id) -> {
            // タップしたメールアイテムを取得
            MailItem selectedMail = mailItems.get(position);

            // MailDetailに選択したメールアイテムを渡して起動
            Intent intent = new Intent(Mail.this, MailDetail.class);
            intent.putExtra(MailDetail.EXTRA_MAIL_ITEM, selectedMail);
            startActivity(intent);
        });
    }

    // ダミーメールデータを返すメソッド
    private List<MailItem> getMailData() {
        List<MailItem> mailItems = new ArrayList<>();
        mailItems.add(new MailItem("メールの件名1", "メールの本文1", "送信者1", "2023-01-01"));
        mailItems.add(new MailItem("メールの件名2", "メールの本文2", "送信者2", "2023-01-02"));
        // 他のメールアイテムを追加することもできます
        return mailItems;
    }
}
