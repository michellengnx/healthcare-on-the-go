package entities.matchers;

import entities.Doctor;
import entities.Service;

import java.util.List;

public interface DoctorMatcherDataAccessInterface {
    public List<Doctor> getAvailableDoctors();
    public List<Doctor> getAvailableDoctors(Service service);
}
