package interface_adapter.LeaveReview;

import entities.Doctor;


public class LeaveReviewState {
    private Integer stars = 4;
    private String message = null;
    private final Doctor doctor = null;


    public Integer getStars() {
        return stars;
    }
    public String getMessage() {
        return message;
    }
    public Doctor getDoctor() {
        return null;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}



