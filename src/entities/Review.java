package org.example.src.entities;

public class Review{
    private String review;
    private DateTime time;
    private int stars; // how many stars for the review can be from 0 to 5

    //preconditions: 0 <= stars <= 5
    public class Review(String review, DateTime time, int stars){
        this.review = review
        this.time = time
        this.stars = stars
    }

    public String getReview() {
        return this.review;
    }

    public DateTime getTime() {
        return this.time;
    }

    public int getStars() {
        return this.stars;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }
}