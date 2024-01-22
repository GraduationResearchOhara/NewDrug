package com.example.newdrug;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountManagementActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_management);

        findViewById(R.id.MedicalStaff).setOnClickListener(v -> {
            Intent intent = new Intent(AccountManagementActivity.this, StaffActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.Patient).setOnClickListener(v -> {
            Intent intent = new Intent(AccountManagementActivity.this, PatientActivity.class);
            startActivity(intent);
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                startActivity(new Intent(AccountManagementActivity.this, Home.class));
                return true;
            } else if (itemId == R.id.navigation_book) {
                // MedicineListActivityに移動
                startActivity(new Intent(AccountManagementActivity.this, MainActivity.class));
                return true;
            } else if (itemId == R.id.navigation_person) {
                // PersonalInformationActivityに移動
                startActivity(new Intent(AccountManagementActivity.this, AccountManagementActivity.class));
                return true;
            } else if (itemId == R.id.navigation_chat) {
                // ChatActivityに移動
                startActivity(new Intent(AccountManagementActivity.this, ChatActivity.class));
                return true;
            } else if (itemId == R.id.navigation_contact) {
                // NoticeActivityに移動
                startActivity(new Intent(AccountManagementActivity.this, Contact.class));
                return true;
            }
            return false;
        });


    }
}