package use_case.LeaveReview;
import entities.Doctor;

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

        Doctor doctor = doctorDAO.getDoctor(leaveReviewInputData.getDoctor());
        doctor.setTotalReviews(doctor.getTotalReviews() + 1);
        int temp = doctor.getTotalReviews();

        doctor.setRating((doctor.getRating()*(temp-1)+ leaveReviewInputData.getStars())/temp);
        doctorDAO.save(doctor);
    }












}
