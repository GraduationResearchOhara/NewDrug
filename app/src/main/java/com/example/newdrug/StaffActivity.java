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

public class StaffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_chat) {
                // チャット画面に遷移
                Intent intent1 = new Intent(StaffActivity.this, ChatActivity.class);
                startActivity(intent1);
                return true;
            } else if (itemId == R.id.navigation_book) {
                // MedicineListActivityに移動
                startActivity(new Intent(StaffActivity.this, SelectMode.class));
                return true;
            } else if (itemId == R.id.navigation_person) {
                // PersonalInformationActivityに移動
                startActivity(new Intent(StaffActivity.this, AccountManagementActivity.class));
                return true;
            } else if (itemId == R.id.navigation_chat) {
                // ChatActivityに移動
                startActivity(new Intent(StaffActivity.this, ChatActivity.class));
                return true;
            } else if (itemId == R.id.navigation_contact) {
                // NoticeActivityに移動
                startActivity(new Intent(StaffActivity.this, Contact.class));
                return true;
            }
            return false;
        });

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
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
                        TextView userTextView = new TextView(StaffActivity.this);
                        userTextView.setText("名前: " + fullName + "\n病院名: " + hospitalName + "\nメール: " + email+ "\n");
                        userTextView.setTextSize(18);
                        userTextView.setPadding(16, 16, 16, 16);

                        // ユーザーごとのクリックリスナーを設定
                        userTextView.setOnClickListener(v -> {
                            // クリックされたユーザーのIDを取得
                            String selectedUserId = userId;

                            // UserDetailActivityに遷移
                            Intent intent = new Intent(StaffActivity.this, StaffDetailActivity.class);
                            intent.putExtra("userId", selectedUserId);
                            startActivity(intent);
                        });

                        // LinearLayoutにTextViewを追加
                        userListLayout.addView(userTextView);
                    }
                } else {
                    // データが存在しない場合の処理
                    Toast.makeText(StaffActivity.this, "データがありません", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // データ取得中にエラーが発生した場合の処理
                Toast.makeText(StaffActivity.this, "データ取得エラー: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
