package com.example.newdrug;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

//        findViewById(R.id.Signup).setOnClickListener(v -> {
//            Intent intent = new Intent(PatientActivity.this, PatientSignupActivity.class);
//            startActivity(intent);
//        });


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Patient");
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();


        // LinearLayoutを取得
        LinearLayout userListLayout = findViewById(R.id.userListLayout);

        // ValueEventListenerを使用してデータ取得
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        // 各ユーザーのデータを取得
                        String fullName = snapshot.child("fullName").getValue(String.class);
                        String hospitalName = snapshot.child("hospitalName").getValue(String.class);
                        String email = snapshot.child("email").getValue(String.class);
                        String userId = snapshot.getKey();

                        // ユーザーごとにTextViewを生成
                        TextView userTextView = new TextView(com.example.newdrug.PatientActivity.this);
                        userTextView.setText("名前: " + fullName + "\n病院名: " + hospitalName + "\nメール: " + email+ "\n");
                        userTextView.setTextSize(18);
                        userTextView.setPadding(16, 16, 16, 16);

                        // ユーザーごとのクリックリスナーを設定
                        userTextView.setOnClickListener(v -> {
                            // クリックされたユーザーのIDを取得
                            String selectedUserId = userId;

                            // UserDetailActivityに遷移
                            Intent intent = new Intent(com.example.newdrug.PatientActivity.this, PatientDetailActivity.class);
                            intent.putExtra("userId", selectedUserId);
                            startActivity(intent);
                        });

                        // LinearLayoutにTextViewを追加
                        userListLayout.addView(userTextView);
                    }
                } else {
                    // データが存在しない場合の処理
                    Toast.makeText(com.example.newdrug.PatientActivity.this, "データがありません", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // データ取得中にエラーが発生した場合の処理
                Toast.makeText(com.example.newdrug.PatientActivity.this, "データ取得エラー: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                // ホームアクティビティの処理
                return true;
            } else if (itemId == R.id.navigation_book) {
                // MedicineListActivityに移動
                startActivity(new Intent(PatientActivity.this, MainActivity.class));
                return true;
            } else if (itemId == R.id.navigation_person) {
                // PersonalInformationActivityに移動
                startActivity(new Intent(PatientActivity.this, AccountManagementActivity.class));
                return true;
            } else if (itemId == R.id.navigation_chat) {
                // ChatActivityに移動
                startActivity(new Intent(PatientActivity.this, ChatActivity.class));
                return true;
            } else if (itemId == R.id.navigation_contact) {
                // NoticeActivityに移動
                startActivity(new Intent(PatientActivity.this, Contact.class));
                return true;
            }
            return false;
        });
    }
}