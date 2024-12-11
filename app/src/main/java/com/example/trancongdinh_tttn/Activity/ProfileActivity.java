package com.example.trancongdinh_tttn.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.trancongdinh_tttn.Helper.UserAuthHelper;
import com.example.trancongdinh_tttn.R;
import com.example.trancongdinh_tttn.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding binding;
    private UserAuthHelper userAuthHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userAuthHelper = new UserAuthHelper(this);

        binding.btnLogOut.setOnClickListener(v -> {
            UserAuthHelper userAuthHelper = new UserAuthHelper(this);

            userAuthHelper.logout();

            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);

        });

        binding.btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
