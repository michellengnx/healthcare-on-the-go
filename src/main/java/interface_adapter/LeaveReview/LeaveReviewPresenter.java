package interface_adapter.LeaveReview ;


import use_case.LeaveReview.LeaveReviewOutputBoundary;
import use_case.LeaveReview.LeaveReviewOutputData;


public class LeaveReviewPresenter implements LeaveReviewOutputBoundary {
    private final LeaveReviewViewModel leaveReviewViewModel;


    public LeaveReviewPresenter(LeaveReviewViewModel leaveReviewViewModel1) {

        this.leaveReviewViewModel = leaveReviewViewModel1;
    }

    @Override
    public void prepareSuccessView(LeaveReviewOutputData review) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
