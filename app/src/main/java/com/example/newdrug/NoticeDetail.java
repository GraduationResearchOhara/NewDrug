package com.example.newdrug;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class NoticeDetail extends AppCompatActivity {

    private ImageButton imageButton;

    public static final String EXTRA_NOTICE_ITEM = "notice_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

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
