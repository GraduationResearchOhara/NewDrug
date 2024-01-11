package com.example.newdrug;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;


public class MailDetail extends AppCompatActivity {

    private ImageButton imageButton;

    public static final String EXTRA_MAIL_ITEM = "mail_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_detail);

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
