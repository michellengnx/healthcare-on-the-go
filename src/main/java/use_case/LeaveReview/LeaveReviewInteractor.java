package use_case.LeaveReview;
import java.time.LocalDateTime;
//Import..


public class LeaveReviewInteractor implements LeaveReviewInputBoundary{
    LeaveReviewDoctorDataAccessInterface doctorDAO;
    LeaveReviewOutputBoundary presenter;

    public LeaveReviewInteractor(LeaveReviewDoctorDataAccessInterface doctorDAO,
                                  LeaveReviewOutputBoundary presenter){
        this.doctorDAO = doctorDAO;
        this.presenter = presenter;

    }
    @Override
    public void execute (LeaveReviewInputData leaveReviewInputData) {
      //  if (doctor not in patient.orderhistory)
        //userPresenter.prepareFailView("You can only rate Doctors you have received service from")
        // else:

    //    review.doctor.settotalreviews(review.doctor.gettotalreviews() + 1);
     //   review.doctor.

    }












}
