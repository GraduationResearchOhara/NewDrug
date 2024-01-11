//package com.example.newdrug;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class MedicationDetailActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_medication_detail);
//
//        // MainActivityから送られたIntentを取得
//        Bundle extras = getIntent().getExtras();
//
//        if (extras != null) {
//            // 詳細情報を表示するためのTextViewを取得
//            TextView nameTextView = findViewById(R.id.detailMedicationName);
//            TextView timeTextView = findViewById(R.id.detailMedicationTime);
//            TextView noteTextView = findViewById(R.id.detailMedicationNote);
//
//            // Intentからデータを取得して表示
//            String medicationName = extras.getString("MEDICATION_NAME");
//            String medicationTime = extras.getString("MEDICATION_TIME");
//            String medicationNote = extras.getString("MEDICATION_NOTE");
//
//            nameTextView.setText(medicationName);
//            timeTextView.setText(medicationTime);
//            noteTextView.setText(medicationNote);
//
////          ImageButtonのクリックリスナーを設定
//            ImageButton imageButton = findViewById(R.id.ImageButton);
//            imageButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // ImageButtonがクリックされた時の処理をここに記述
//                    // 例: トーストメッセージを表示
//                    finish();
//                }
//            });
//
//
//        }
//    }
//}
