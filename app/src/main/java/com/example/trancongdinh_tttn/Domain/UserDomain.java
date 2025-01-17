package com.example.trancongdinh_tttn.Domain;

public class UserDomain {
    private String username;
    private String password;
    private String confirmPassword;

    public UserDomain(String username, String email, String confirmPassword, String password) {
        this.username = username;
        this.email = email;
        this.confirmPassword = confirmPassword;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
}
