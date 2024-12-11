package com.example.trancongdinh_tttn.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.trancongdinh_tttn.Adapter.PopularAdapter;
import com.example.trancongdinh_tttn.Domain.PopularDomain;
import com.example.trancongdinh_tttn.Helper.UserAuthHelper;
import com.example.trancongdinh_tttn.R;
import com.example.trancongdinh_tttn.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        statusBarColor();
        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.cartBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void statusBarColor() {
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_Dark));
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("item_1","T-shirt black",15,500,4.0,"Imerse yourself in a world of vibrant visuals and\n" +
                "imersive sound with the monitor.\n" +
                "Its cuting-edge monitor technology brings every\n" +
                "scene to life with tricking clarity and rich colors.\n" +
                "With the seamless integration and a sleek, modern\n" +
                "design, the monitor Pro is not just a monitor but a\n"+
                "centerpiece for your entertainment space.\n"+
                "With its sleek, modern design, the monitor is\n"+
                "not just a TV, but a centerpiece for your\n"+
                "entertainment space. The ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));

        items.add(new PopularDomain("item_2","Smart Watch",10,450,4.5,"Imerse yourself in a world of vibrant visuals and\n" +
                "imersive sound with the monitor.\n" +
                "Its cuting-edge monitor technology brings every\n" +
                "scene to life with tricking clarity and rich colors.\n" +
                "With the seamless integration and a sleek, modern\n" +
                "design, the monitor Pro is not just a monitor but a\n"+
                "centerpiece for your entertainment space.\n"+
                "With its sleek, modern design, the monitor is\n"+
                "not just a TV, but a centerpiece for your\n"+
                "entertainment space. The ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));
        items.add(new PopularDomain("item_3","Phone",3,1000,4.9,"Imerse yourself in a world of vibrant visuals and\n" +
                "imersive sound with the monitor.\n" +
                "Its cuting-edge monitor technology brings every\n" +
                "scene to life with tricking clarity and rich colors.\n" +
                "With the seamless integration and a sleek, modern\n" +
                "design, the monitor Pro is not just a monitor but a\n"+
                "centerpiece for your entertainment space.\n"+
                "With its sleek, modern design, the monitor is\n"+
                "not just a TV, but a centerpiece for your\n"+
                "entertainment space. The ultra-slim bezel and\n"+
                "premium finish blend seamlessly with any decor"));

        binding.btnProfile.setOnClickListener(v -> {
            UserAuthHelper userAuthHelper = new UserAuthHelper(this);

            if (userAuthHelper.isLoggedIn()) {
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL,false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}