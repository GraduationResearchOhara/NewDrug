package com.example.newdrug;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ChildEventListener;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private EditText messageEditText;
    private Button sendButton;
    private ListView chatListView;
    private ArrayList<String> chatMessages;
    private ArrayAdapter<String> chatAdapter;
    DatabaseReference mDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);

        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        chatListView = findViewById(R.id.chatListView);
        chatMessages = new ArrayList<>();
        chatAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chatMessages);
        chatListView.setAdapter(chatAdapter);

        // Firebaseとの連携など
        mDatabase = FirebaseDatabase.getInstance().getReference();
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString().trim();
                if (!message.isEmpty()) {
                    // 新しいメッセージをチャット履歴に追加
                    chatMessages.add("user1: " + message);
                    chatAdapter.notifyDataSetChanged();

                    sendMessage();
                }
            }
        });
        receiveMessages();
    }

    //書き込み
    private void sendMessage() {
        String messageText = messageEditText.getText().toString().trim();
        if (!messageText.isEmpty()) {
            // pushでデータを追加していく
            DatabaseReference messageRef = mDatabase.child("messages").push();

            String username = "user1"; // データベースと一致させるユーザー名
            messageRef.setValue(new Message(username, messageText));
            //入力欄のテキストを削除する
            messageEditText.setText("");
        }
    }

    //読み取り
    private void receiveMessages() {
        mDatabase.child("messages").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Message newMessage = dataSnapshot.getValue(Message.class);
                chatMessages.add(newMessage.getUsername() + ": " + newMessage.getText());
                chatAdapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                // メッセージが変更された時の処理
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                // メッセージが削除された時の処理
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
                // メッセージが移動した時の処理
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // エラーが発生した時の処理
                Log.e(TAG, "Failed to load messages.", databaseError.toException());
            }

        });
    }

    @IgnoreExtraProperties
    public static class Message {
        private String username;
        private String text;

        public Message() {
            // Firebase用のデフォルトコンストラクタ
        }

        public Message(String username, String text) {
            this.username = username;
            this.text = text;
        }

        public String getUsername() {
            return username;
        }

        public String getText() {
            return text;
        }
    }
}

