package com.example.trancongdinh_tttn.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.trancongdinh_tttn.Adapter.UserAdapter;
import com.example.trancongdinh_tttn.R;
import com.example.trancongdinh_tttn.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userAdapter = new UserAdapter(this);


        binding.btnLogin.setOnClickListener(v -> {
            String username = binding.edtUserName.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();

            String result = userAdapter.loginUser(username, password);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

            if ("Login successful!".equals(result)) {
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        binding.btnRegisterNow.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}
