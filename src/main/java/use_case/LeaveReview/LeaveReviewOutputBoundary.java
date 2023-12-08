package use_case.LeaveReview;

public interface LeaveReviewOutputBoundary {
    void prepareSuccessView(LeaveReviewOutputData review);

    void prepareFailView(String error);

}
