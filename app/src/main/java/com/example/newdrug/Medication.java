package com.example.newdrug;
//
//public class Medication {
//    private String name;
//    private String time;
//    private String note;
//
//    public Medication(String name, String time, String note) {
//        this.name = name;
//        this.time = time;
//        this.note = note;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public String getNote() {
//        return note;
//    }
//}

//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//
//import android.webkit.WebSettings;
//
//import android.widget.Toast;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class Medication extends AppCompatActivity {
//    private class MyWebViewClient extends WebViewClient {
//        @Override
//        public void onReceivedError(WebView view, int errcode, String desc, String url) {
//            String s = "error:(" + errcode + ")" + desc;
//            Toast.makeText(Medication.this, s, Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @SuppressLint("SetJavaScriptEnabled")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_medication);
//
//        // ブラウジングの設定（JavaScriptの使用を許可し、ズームを禁止）
//        View webView = findViewById(R.id.webView);
//        WebView wv = new WebView(this);
//        WebSettings sets = wv.getSettings();
//        sets.setJavaScriptEnabled(true);
//        sets.setSupportMultipleWindows(false);
//        wv.setWebViewClient(new MyWebViewClient());
//        setContentView(wv);
//
//        wv.loadUrl("https://www.drugs.com/drug_information.html");
//    }
//
//}