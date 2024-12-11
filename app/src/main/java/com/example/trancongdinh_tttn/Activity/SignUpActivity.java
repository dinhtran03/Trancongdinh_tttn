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
import com.example.trancongdinh_tttn.Domain.UserDomain;
import com.example.trancongdinh_tttn.R;
import com.example.trancongdinh_tttn.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userAdapter = new UserAdapter(this);

        binding.btnLogin.setOnClickListener(v -> {
            String username = binding.edtUserName.getText().toString().trim();
            String email = binding.edtEmail.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();
            String confirmPassword = binding.edtConfirmPassword.getText().toString().trim();

            UserDomain newUser = new UserDomain(username, email, confirmPassword, password);
            String result = userAdapter.registerUser(newUser);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

            if ("Registration successful".equals(result)) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.btnLoginNow.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

    }
}