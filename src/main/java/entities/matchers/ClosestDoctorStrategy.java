package entities.matchers;

import entities.Doctor;
import entities.Service;

import java.util.Map;

import static entities.matchers.MapUtils.filterDoctorsWithService;
import static entities.matchers.MapUtils.minKey;

public class ClosestDoctorStrategy implements DoctorMatchingStrategy {
    private final Map<Doctor, Float> availableDoctorDistances;

    public ClosestDoctorStrategy(Map<Doctor, Float> availableDoctorDistances) {
        this.availableDoctorDistances = availableDoctorDistances;
    }

    /**
     * Find the doctor that is the best match for the requested service. Prioritize finding the doctor that is
     * specialized to provide this.service and is the closest in terms of distance. However, if the closest
     * specialized doctor is 100km or greater away, simply return the closest doctor.
     * @return Return the best Doctor for the requested service and destination
     * @throws NoAvailableDoctorException If there are no available doctors
     */
    public Doctor match(Service service) throws NoAvailableDoctorException {
        Doctor closestDoctor = minKey(availableDoctorDistances);
        Doctor closestDoctorWithService;

        Map<Doctor, Float> availableDoctorsWithServiceEtas = filterDoctorsWithService(availableDoctorDistances, service);

        try {
            closestDoctorWithService = minKey(availableDoctorsWithServiceEtas);
        } catch (NoAvailableDoctorException e) {
            return closestDoctor;
        }

        float etaDoctorWithService = availableDoctorDistances.get(closestDoctorWithService);

        if (etaDoctorWithService < 100) {
            return closestDoctorWithService;
        } else {
            return closestDoctor;
        }
    }
}
