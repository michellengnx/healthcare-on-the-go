package use_case.LeaveReview;
import entities.*;

public class LeaveReviewInteractor {
    LeaveReviewDoctorDataAccessInterface doctorDAO;
    LeaveReviewOutputBoundary presenter;



    public LeaveReviewInteractor(LeaveReviewDoctorDataAccessInterface doctorDAO,
                                  LeaveReviewOutputBoundary presenter){
        this.doctorDAO = doctorDAO;
        this.presenter = presenter;

    }
    public void execute (LeaveReviewInputData leaveReviewInputData) {
        review.doctor.settotalreviews(review.doctor.gettotalreviews() + 1);
        review.doctor.
    }










}
