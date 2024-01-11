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

public class Notice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        // ボトムナビゲーションバーの初期設定
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId(); // メニューアイテムのIDを取得

                if (itemId == R.id.navigation_chat) {
                    // チャット画面に遷移
                    Intent intent1 = new Intent(Notice.this, Chat.class);
                    startActivity(intent1);
                    return true;
                } else if (itemId == R.id.navigation_book) {
                    // お薬手帳に遷移
                    Intent intent2 = new Intent(Notice.this, MainActivity.class);
                    startActivity(intent2);
                    return true;
                } else if (itemId == R.id.navigation_contact) {
                    // 連絡に遷移
                    Intent intent3 = new Intent(Notice.this, Contact.class);
                    startActivity(intent3);
                    return true;
                } else if (itemId == R.id.navigation_person) {
                    // 個人情報に遷移
                    Intent intent4 = new Intent(Notice.this, PersonalInformation.class);
                    startActivity(intent4);
                    return true;
                }else if (itemId == R.id.navigation_home) {
                    // homeに遷移
                    Intent intent5 = new Intent(Notice.this, Home.class);
                    startActivity(intent5);
                    return true;
                }
                return false;
            }
        });

        // お知らせデータを取得する（ここではダミーデータを使用）
        List<NoticeItem> noticeItems = getNoticeData();

        // リストビューのIDを取得
        ListView noticeListView = findViewById(R.id.noticeListView);

        // お知らせアイテムを表示するためのアダプターを作成
        ArrayAdapter<NoticeItem> noticeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noticeItems);

        // リストビューにアダプターをセット
        noticeListView.setAdapter(noticeAdapter);

        // お知らせアイテムがタップされたときのリスナーを設定
        noticeListView.setOnItemClickListener((parent, view, position, id) -> {
            // タップしたお知らせアイテムを取得
            NoticeItem selectedNotice = noticeItems.get(position);

            // NoticeDetailに選択したお知らせアイテムを渡して起動
            Intent intent = new Intent(Notice.this, NoticeDetail.class);
            intent.putExtra(NoticeDetail.EXTRA_NOTICE_ITEM, selectedNotice);
            startActivity(intent);
        });
    }

    // お知らせデータを返すメソッド（実際のデータ取得ロジックをここに実装する）
    private List<NoticeItem> getNoticeData() {
        List<NoticeItem> noticeItems = new ArrayList<>();
        // 実際のお知らせデータ取得ロジックを実装する（ここではダミーデータを返している）
        noticeItems.add(new NoticeItem("2023-01-01", "お知らせ1", "お知らせの内容1"));
        noticeItems.add(new NoticeItem("2023-01-02", "お知らせ2", "お知らせの内容2"));
        // 他のお知らせアイテムを追加することもできます
        return noticeItems;
    }
}
