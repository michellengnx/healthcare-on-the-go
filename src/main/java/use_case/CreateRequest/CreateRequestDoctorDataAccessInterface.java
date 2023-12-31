package use_case.CreateRequest;

import entities.Doctor;
import entities.Service;

import java.util.List;

/**
 * Methods that the doctor data access object must implement for the create request interactor to function properly.
 */
public interface CreateRequestDoctorDataAccessInterface {
    /**
     * Return all doctors that are available (i.e. not tending to another request).
     *
     * @return A list of all doctors that are available.
     */
    public List<Doctor> getAvailableDoctors();

    /**
     * Mark a doctor as busy (i.e. tending to a request)
     *
     * @param doctor The doctor to be marked as busy
     */
    public void markAsBusy(Doctor doctor);
}
