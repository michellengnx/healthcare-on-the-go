package entities.matchers;

import entities.Doctor;
import entities.Service;

public interface DoctorMatchingStrategy {

    /**
     * Find the doctor that is the best match for a service request.
     *
     * @return The doctor determined to be the best match.
     */
    public Doctor match(Service service) throws NoAvailableDoctorException;
}
