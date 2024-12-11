package com.example.trancongdinh_tttn.Domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String title;
    private String picUrl;
    private double price;
    private int review;
    private  int numberInCart;
    private double score;
    private String description;



    public void setDescription(String description) {
        this.description = description;
    }

    public PopularDomain(String picUrl, String title, int review, double price, double score, String description) {
        this.picUrl = picUrl;
        this.title = title;
        this.price = price;
        this.review = review;
        this.score = score;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void getNumberInCart(int numberOrder) {

    }
}
