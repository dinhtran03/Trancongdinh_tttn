package com.example.trancongdinh_tttn.Adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trancongdinh_tttn.Domain.UserDomain;
import com.example.trancongdinh_tttn.Helper.UserAuthHelper;
import com.example.trancongdinh_tttn.databinding.ViewholderPupListBinding;

import java.util.List;


public class UserAdapter {
    private UserAuthHelper userAuthHelper;

    public UserAdapter(Context context) {
        userAuthHelper = new UserAuthHelper(context);
    }

    public String registerUser(UserDomain user) {
        return userAuthHelper.registerUser(
                user.getUsername(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getEmail()
        );
    }

    public String loginUser(String username, String password) {
        return userAuthHelper.loginUser(username, password);
    }
}

