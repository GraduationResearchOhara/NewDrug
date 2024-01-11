package com.example.newdrug;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal); // このレイアウトは作成する必要があります

        TextView textView = findViewById(R.id.textView);
        textView.setText("判定が成功しました！");
    }
}