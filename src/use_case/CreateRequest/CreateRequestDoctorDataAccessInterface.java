package use_case.CreateRequest;

import entities.Doctor;
import entities.Service;

import java.util.List;

public interface CreateRequestDoctorDataAccessInterface {
    public List<Doctor> getAvailableDoctors();
    public List<Doctor> getAvailableDoctors(Service service);
    public void markAsBusy(Doctor doctor);
}
