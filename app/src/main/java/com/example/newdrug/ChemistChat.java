package com.example.newdrug;

import android.widget.ImageButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ChemistChat extends AppCompatActivity {

    private EditText messageEditText;
    private Button sendButton;
    private ImageButton imageButton;
    private ListView chatListView;
    private ArrayList<String> chatMessages;
    private ArrayAdapter<String> chatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemist_chat);

        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        imageButton = findViewById(R.id.ImageButton);
        chatListView = findViewById(R.id.chatListView);

        chatMessages = new ArrayList<>();
        chatAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chatMessages);
        chatListView.setAdapter(chatAdapter);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString().trim();
                if (!message.isEmpty()) {
                    // 新しいメッセージをチャット履歴に追加
                    chatMessages.add("You: " + message);
                    chatAdapter.notifyDataSetChanged();
                    // メッセージを入力欄から削除
                    messageEditText.setText("");
                }
            }
        });

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
