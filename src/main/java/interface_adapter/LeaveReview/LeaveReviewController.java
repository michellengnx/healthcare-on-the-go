package interface_adapter.LeaveReview;

import use_case.LeaveReview.LeaveReviewInputBoundary;
import use_case.LeaveReview.LeaveReviewInputData;

import java.util.Date;

public class LeaveReviewController {
    final LeaveReviewInputBoundary userLeaveReviewUseCaseInteractor;
    public LeaveReviewController(LeaveReviewInputBoundary userLeaveReviewUseCaseInteractor) {
        this.userLeaveReviewUseCaseInteractor=userLeaveReviewUseCaseInteractor;
    }

    public void execute(String review, int stars, String doctorName, Date reviewdate) {
        LeaveReviewInputData leaveReviewInputData = new LeaveReviewInputData(review, stars, doctorName, reviewdate);
        userLeaveReviewUseCaseInteractor.execute(leaveReviewInputData);



    }

}
