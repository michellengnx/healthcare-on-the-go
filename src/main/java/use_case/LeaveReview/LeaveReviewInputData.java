package use_case.LeaveReview;
import entities.Doctor;
import java.util.Date;

public class LeaveReviewInputData {
    String review;
    int stars;
    Doctor doctor;
    Date reviewdate;

    public LeaveReviewInputData(String review, int stars, Doctor doctor, Date reviewdate){
        this.review = review;
        this.stars = stars;
        this.doctor = doctor;
        this.reviewdate = reviewdate;

    }
    String getReview() {
        return review;
    }
    int getStars() {
        return stars;
    }
    Doctor getDoctor() {
        return doctor;
    }

    Date getReviewDate() {
        return reviewdate;
    }
}
