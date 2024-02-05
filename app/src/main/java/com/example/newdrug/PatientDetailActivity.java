//package com.example.newdrug;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//public class PatientDetailActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_patientdetail);
//
//        // IntentからユーザーIDを取得
//        String userId = getIntent().getStringExtra("userId");
//
//        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("Patient").child(userId);
//
//        // UIのTextView
//        TextView fullNameTextView = findViewById(R.id.fullNameTextView);
//        TextView hospitalNameTextView = findViewById(R.id.hospitalNameTextView);
//        TextView emailTextView = findViewById(R.id.emailTextView);
//
//        // ユーザー情報を読み込んでUIに表示
//        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    // ユーザーのデータを取得
//                    String fullName = dataSnapshot.child("fullName").getValue(String.class);
//                    String hospitalName = dataSnapshot.child("hospitalName").getValue(String.class);
//                    String email = dataSnapshot.child("email").getValue(String.class);
//
//                    // 取得したデータをTextViewにセット
//                    fullNameTextView.setText("名前: " + fullName);
//                    hospitalNameTextView.setText("病院名: " + hospitalName);
//                    emailTextView.setText("メール: " + email);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // エラーが発生した場合の処理
//            }
//        });
//
//        Button returnToListButton = findViewById(R.id.listButton);
//        returnToListButton.setOnClickListener(v -> {
//            // 一覧画面に遷移
//            startActivity(new Intent(PatientDetailActivity.this, PatientActivity.class));
//            // Replace YourListActivity.class with the actual class of the list activity you want to navigate back to.
//        });
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            int itemId = item.getItemId();
//            if (itemId == R.id.navigation_home) {
//                // ホームアクティビティの処理
//                return true;
//            } else if (itemId == R.id.navigation_book) {
//                // MedicineListActivityに移動
//                startActivity(new Intent(PatientDetailActivity.this, MainActivity.class));
//                return true;
//            } else if (itemId == R.id.navigation_person) {
//                // PersonalInformationActivityに移動
//                startActivity(new Intent(PatientDetailActivity.this, AccountManagementActivity.class));
//                return true;
//            } else if (itemId == R.id.navigation_chat) {
//                // ChatActivityに移動
//                startActivity(new Intent(PatientDetailActivity.this, ChatActivity.class));
//                return true;
//            } else if (itemId == R.id.navigation_contact) {
//                // NoticeActivityに移動
//                startActivity(new Intent(PatientDetailActivity.this, Contact.class));
//                return true;
//            }
//            return false;
//        });
//    }
//}

//package com.example.kuboryusei;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//public class PatientDetailActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_patientdetail);
//
//        // IntentからユーザーIDを取得
//        String userId = getIntent().getStringExtra("userId");
//
//        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("Patient").child(userId);
//
//        // UIのTextView
//        TextView fullNameTextView = findViewById(R.id.fullNameTextView);
//        TextView hospitalNameTextView = findViewById(R.id.hospitalNameTextView);
//        TextView emailTextView = findViewById(R.id.emailTextView);
//        TextView birthDateTextView = findViewById(R.id.birthDateTextView);
//
//        // ユーザー情報を読み込んでUIに表示
//        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    // ユーザーのデータを取得
//                    String fullName = dataSnapshot.child("fullName").getValue(String.class);
//                    String hospitalName = dataSnapshot.child("hospitalName").getValue(String.class);
//                    String email = dataSnapshot.child("email").getValue(String.class);
//                    // 追加：生年月日を取得
//                    int birthYear = dataSnapshot.child("birthYear").getValue(Integer.class);
//                    int birthMonth = dataSnapshot.child("birthMonth").getValue(Integer.class);
//                    int birthDay = dataSnapshot.child("birthDay").getValue(Integer.class);
//
//
//
//                    // 取得したデータをTextViewにセット
//                    fullNameTextView.setText("名前: " + fullName);
//
//                    hospitalNameTextView.setText("病院名: " + hospitalName);
//                    emailTextView.setText("メール: " + email);
//                    // 追加：生年月日をTextViewにセット
//                    birthDateTextView.setText("生年月日: " + birthYear + "年" + birthMonth + "月" + birthDay + "日");
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // エラーが発生した場合の処理
//            }
//        });
//
//        Button editButton = findViewById(R.id.editButton);
//        editButton.setOnClickListener(v -> {
//            // 編集画面に遷移
//            Intent editIntent = new Intent(PatientDetailActivity.this, PatientEditActivity.class);
//            editIntent.putExtra("userId", userId);
//            startActivity(editIntent);
//        });
//        Button returnToListButton = findViewById(R.id.listButton);
//        returnToListButton.setOnClickListener(v -> {
//            // 一覧画面に遷移
//            startActivity(new Intent(PatientDetailActivity.this, PatientActivity.class));
//            // Replace YourListActivity.class with the actual class of the list activity you want to navigate back to.
//        });
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            int itemId = item.getItemId();
//            if (itemId == R.id.navigation_home) {
//                // ホームアクティビティの処理
//                return true;
//            } else if (itemId == R.id.navigation_medicine_list) {
//                // MedicineListActivityに移動
//                startActivity(new Intent(PatientDetailActivity.this, MedicineListActivity.class));
//                return true;
//            } else if (itemId == R.id.navigation_personal_information) {
//                // PersonalInformationActivityに移動
//                startActivity(new Intent(PatientDetailActivity.this, AccountManagementActivity.class));
//                return true;
//            } else if (itemId == R.id.navigation_chat) {
//                // ChatActivityに移動
//                startActivity(new Intent(PatientDetailActivity.this, ChatActivity.class));
//                return true;
//            } else if (itemId == R.id.navigation_notice) {
//                // NoticeActivityに移動
//                startActivity(new Intent(PatientDetailActivity.this, NotificationsActivity.class));
//                return true;
//            }
//            return false;
//        });
//    }
//}


package com.example.newdrug;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PatientDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientdetail);

        // IntentからユーザーIDを取得
        String userId = getIntent().getStringExtra("userId");

        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("Patient").child(userId);

        // UIのTextView
        TextView fullNameTextView = findViewById(R.id.fullNameTextView);
        TextView hospitalNameTextView = findViewById(R.id.hospitalNameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView birthDateTextView = findViewById(R.id.birthDateTextView);

        // ユーザー情報を読み込んでUIに表示
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // ユーザーのデータを取得
                    String fullName = dataSnapshot.child("fullName").getValue(String.class);
                    String hospitalName = dataSnapshot.child("hospitalName").getValue(String.class);
                    String email = dataSnapshot.child("email").getValue(String.class);
                    // 追加：生年月日を取得
                    int birthYear = dataSnapshot.child("birthYear").getValue(Integer.class);
                    int birthMonth = dataSnapshot.child("birthMonth").getValue(Integer.class);
                    int birthDay = dataSnapshot.child("birthDay").getValue(Integer.class);



                    // 取得したデータをTextViewにセット
                    fullNameTextView.setText("名前: " + fullName);

                    hospitalNameTextView.setText("病院名: " + hospitalName);
                    emailTextView.setText("メール: " + email);
                    // 追加：生年月日をTextViewにセット
                    birthDateTextView.setText("生年月日: " + birthYear + "年" + birthMonth + "月" + birthDay + "日");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // エラーが発生した場合の処理
            }
        });

        Button returnToListButton = findViewById(R.id.listButton);
        returnToListButton.setOnClickListener(v -> {
            // 一覧画面に遷移
            startActivity(new Intent(PatientDetailActivity.this, PatientActivity.class));
            // Replace YourListActivity.class with the actual class of the list activity you want to navigate back to.
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                // ホームアクティビティの処理
                startActivity(new Intent(PatientDetailActivity.this, Home.class));
                return true;
            } else if (itemId == R.id.navigation_book) {
                // MedicineListActivityに移動
                startActivity(new Intent(PatientDetailActivity.this, SelectMode.class));
                return true;
            } else if (itemId == R.id.navigation_person) {
                // PersonalInformationActivityに移動
                startActivity(new Intent(PatientDetailActivity.this, AccountManagementActivity.class));
                return true;
            } else if (itemId == R.id.navigation_chat) {
                // ChatActivityに移動
                startActivity(new Intent(PatientDetailActivity.this, ChatActivity.class));
                return true;
            } else if (itemId == R.id.navigation_contact) {
                // NoticeActivityに移動
                startActivity(new Intent(PatientDetailActivity.this, Contact.class));
                return true;
            }
            return false;
        });
    }
}