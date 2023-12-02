package interface_adapter.LeaveReview ;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestState;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.CreateRequest.CreateRequestOutputData;
import use_case.LeaveReview.LeaveReviewOutputBoundary;
import use_case.LeaveReview.LeaveReviewOutputData;


public class LeaveReviewPresenter implements LeaveReviewOutputBoundary {


    public LeaveReviewPresenter(LeaveReviewViewModel leaveReviewViewModel) {
    }

    @Override
    public void prepareSuccessView(LeaveReviewOutputData review) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
