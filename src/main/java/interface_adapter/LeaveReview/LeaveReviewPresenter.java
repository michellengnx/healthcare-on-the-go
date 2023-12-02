package interface_adapter.LeaveReview;

import use_case.LeaveReview.LeaveReviewOutputBoundary;
import use_case.LeaveReview.LeaveReviewOutputData;

public class LeaveReviewPresenter implements LeaveReviewOutputBoundary {
    private final LeaveReviewViewModel leaveReviewViewModel;










    @Override
    public void prepareSuccessView(LeaveReviewOutputData review) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
