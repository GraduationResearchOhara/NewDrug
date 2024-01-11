package com.example.newdrug;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ListView;
//
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // ボトムナビゲーションバーの初期設定
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int itemId = item.getItemId(); // メニューアイテムのIDを取得
//
//                if (itemId == R.id.navigation_chat) {
//                    // チャット画面に遷移
//                    Intent intent1 = new Intent(MainActivity.this, Chat.class);
//                    startActivity(intent1);
//                    return true;
//                } else if (itemId == R.id.navigation_book) {
//                    // お薬手帳に遷移
//                    Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
//                    startActivity(intent2);
//                    return true;
//                } else if (itemId == R.id.navigation_contact) {
//                    // 連絡に遷移
//                    Intent intent3 = new Intent(MainActivity.this, Contact.class);
//                    startActivity(intent3);
//                    return true;
//                } else if (itemId == R.id.navigation_person) {
//                    // 個人情報に遷移
//                    Intent intent4 = new Intent(MainActivity.this, PersonalInformation.class);
//                    startActivity(intent4);
//                    return true;
//                }
//                else if (itemId == R.id.navigation_home) {
//                    // Home画面に遷移
//                    Intent intentHome = new Intent(MainActivity.this, Home.class);
//                    startActivity(intentHome);
//                    return true;
//                }
//                return false;
//            }
//        });
//
//
//        List<Medication> medications = new ArrayList<>();
//        medications.add(new Medication("薬1", "8:00", "備考1"));
//        medications.add(new Medication("薬2", "12:00", "備考2"));
//        medications.add(new Medication("薬3", "18:00", "備考3"));
//
//        MedicationAdapter adapter = new MedicationAdapter(this, medications);
//        ListView listView = findViewById(R.id.medicationListView);
//        listView.setAdapter(adapter);
//
//        // ListViewのアイテムクリックリスナーを設定
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // クリックされたアイテムのデータを取得
//                Medication selectedMedication = medications.get(position);
//
//                // MedicationDetailActivityにデータを渡すためのIntentを作成
//                Intent intent = new Intent(MainActivity.this, MedicationDetailActivity.class);
//                intent.putExtra("MEDICATION_NAME", selectedMedication.getName());
//                intent.putExtra("MEDICATION_TIME", selectedMedication.getTime());
//                intent.putExtra("MEDICATION_NOTE", selectedMedication.getNote());
//
//                // MedicationDetailActivityに遷移
//                startActivity(intent);
//            }
//        });
//
//        // ImageButtonのクリックリスナーを設定
//        ImageButton imageButton = findViewById(R.id.ImageButton);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // ImageButtonがクリックされた時の処理をここに記述
//                // 例: トーストメッセージを表示
//                finish();
//            }
//        });
//
//        Button confButton = findViewById(R.id.confButton);
//        confButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, GraphActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.webkit.WebSettings;

import android.widget.Toast;

import com.example.newdrug.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onReceivedError(WebView view, int errcode, String desc, String url) {
            String s = "error:(" + errcode + ")" + desc;
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);

        // ブラウジングの設定（JavaScriptの使用を許可し、ズームを禁止）
        View webView = findViewById(R.id.webView);
        WebView wv = new WebView(this);
        WebSettings sets = wv.getSettings();
        sets.setJavaScriptEnabled(true);
        sets.setSupportMultipleWindows(false);
        wv.setWebViewClient(new MyWebViewClient());
        setContentView(wv);

        wv.loadUrl("https://www.drugs.com/drug_information.html");
    }

}