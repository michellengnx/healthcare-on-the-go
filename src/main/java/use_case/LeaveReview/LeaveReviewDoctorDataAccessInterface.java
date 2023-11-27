package use_case.LeaveReview;

import entities.Doctor;

public interface LeaveReviewDoctorDataAccessInterface {

    public Doctor getDoctor(String doctorName);
    public void save(Doctor doctor);
}
