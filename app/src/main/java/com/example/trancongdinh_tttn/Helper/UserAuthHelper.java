package com.example.trancongdinh_tttn.Helper;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class UserAuthHelper {
    private TinyDB tinyDB;
    private Context context;

    public UserAuthHelper(Context context) {
        this.context = context;
        tinyDB = new TinyDB(context);
    }

    public String registerUser(String username, String password, String confirmPassword, String email) {
        if (username==null || username.trim().isEmpty()){
            return "Username cannot be blank.";
        }

        if (password==null || password.trim().isEmpty()){
            return "Password cannot be blank.";
        }

        if (!password.equals(confirmPassword)){
            return "Password and confirm password do not match.";
        }


        if (email == null || !email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            return "Invalid email address.";
        }

        ArrayList<String> existingUsers = tinyDB.getListString("usernames");
        if (existingUsers.contains(username)) {
            return "Account name already exists. Please choose another name.";
        }

        existingUsers.add(username);
        tinyDB.putListString("usernames", existingUsers);

        tinyDB.putString(username + "_password", password);
        tinyDB.putString(username + "_username", username);

        return "Registration successful";
    }

    public String loginUser(String username, String password) {
        if (username==null || username.trim().isEmpty()){
            return "Username cannot be blank.";
        }
        if (password==null || password.trim().isEmpty()){
            return "Password cannot be blank.";
        }

        ArrayList<String> existingUsers = tinyDB.getListString("usernames");
        if (!existingUsers.contains(username)) {
            return "Account does not exist.";
        }
        String storedPassword = tinyDB.getString(username + "_password");
        if (!storedPassword.equals(password)) {
            return "Incorrect password.";
        }
        return "Login successful!";
    }


    public boolean isLoggedIn() {
        return tinyDB.getBoolean("isLoggedIn", false);
    }

    public void setLoggedIn(String username) {
        tinyDB.putBoolean("isLoggedIn", true);
        tinyDB.putString("currentUser", username);
    }

    public void logout() {
        tinyDB.putBoolean("isLoggedIn", false);
        tinyDB.putString("currentUser", null);
    }


}
