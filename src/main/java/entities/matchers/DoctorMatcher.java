package entities.matchers;

import entities.Doctor;
import entities.Service;

public class DoctorMatcher {
    private final Service service;
    private final DoctorMatchingStrategy matchingStrategy;

    /**
     * Create a doctor matcher for a given service and map of available doctors
     *
     * @param service The service being requested
     * @param matchingStrategy The strategy used to match a doctor with a requested service
     */
    public DoctorMatcher(Service service,
                         DoctorMatchingStrategy matchingStrategy) {
        this.service = service;
        this.matchingStrategy = matchingStrategy;
    }

    /**
     * Find the doctor that is the best match for the requested service based on the service requested, and the
     * desired strategy.
     * @throws NoAvailableDoctorException If there are no available doctors
     */
    public Doctor match() throws NoAvailableDoctorException {
        return matchingStrategy.match(service);
    }
}