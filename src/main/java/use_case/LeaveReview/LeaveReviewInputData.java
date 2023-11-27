package use_case.LeaveReview;
import entities.Doctor;
import java.util.Date;

public class LeaveReviewInputData {
    String review;
    int stars;
    String doctorName;
    Date reviewdate;

    public LeaveReviewInputData(String review, int stars, String doctorName, Date reviewdate){
        this.review = review;
        this.stars = stars;
        this.doctorName = doctorName;
        this.reviewdate = reviewdate;

    }
    String getReview() {
        return review;
    }
    int getStars() {
        return stars;
    }
    String getDoctor() {
        return doctorName ;
    }
    Date getReviewDate() {
        return reviewdate;
    }
}
