package entities.matchers;

import entities.Doctor;
import entities.Service;

import java.util.Map;

import static entities.matchers.MapUtils.filterDoctorsWithService;
import static entities.matchers.MapUtils.minKey;

public class LowestEtaDoctorStrategy implements DoctorMatchingStrategy {

    private final Map<Doctor, Float> availableDoctorEtas;

    public LowestEtaDoctorStrategy(Map<Doctor, Float> availableDoctorEtas) {
        this.availableDoctorEtas = availableDoctorEtas;
    }

    /**
     * Find the doctor that is the best match for the requested service. Prioritize finding the doctor that is
     * specialized to provide this.service and can arrive in the shortest amount of time. However, if the closest
     * specialized doctor is 1hr or greater away, simply return the doctor that can arrive the fastest.
     * @return Return the best Doctor for the requested service and destination
     * @throws NoAvailableDoctorException If there are no available doctors
     */
    public Doctor match(Service service) throws NoAvailableDoctorException {
        Doctor closestDoctor = minKey(availableDoctorEtas);
        Doctor closestDoctorWithService;

        Map<Doctor, Float> availableDoctorsWithServiceEtas = filterDoctorsWithService(availableDoctorEtas, service);

        try {
            closestDoctorWithService = minKey(availableDoctorsWithServiceEtas);
        } catch (NoAvailableDoctorException e) {
            return closestDoctor;
        }

        float etaDoctorWithService = availableDoctorEtas.get(closestDoctorWithService);

        if (etaDoctorWithService < 60) {
            return closestDoctorWithService;
        } else {
            return closestDoctor;
        }
    }
}
