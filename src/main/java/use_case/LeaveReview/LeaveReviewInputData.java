package use_case.LeaveReview;
import entities.Doctor;

import java.util.Date;

public class LeaveReviewInputData {
    String review;
    int stars;
    Doctor doctor;

    public LeaveReviewInputData(String review, int stars, Doctor doctor){
        this.review = review;
        this.stars = stars;
        this.doctor = doctor;

    }




}
