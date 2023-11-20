package entities.matchers;

import entities.Doctor;
import entities.Service;
import use_case.CreateRequest.CreateRequestApiAccessInterface;
import use_case.CreateRequest.CreateRequestDoctorDataAccessInterface;
import use_case.CreateRequest.NoAvailableDoctorException;

import javax.print.Doc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorMatcher {
    private final Service service;
    private final Map<Doctor, Float> availableDoctorEtas;

    /**
     * Create a doctor matcher for a given service and map of available doctors
     *
     * @param service The service being requested
     * @param availableDoctorEtas Map from available Doctors to their ETAs from the destination
     */
    public DoctorMatcher(Service service,
                         Map<Doctor, Float> availableDoctorEtas) {
        this.service = service;
        this.availableDoctorEtas = availableDoctorEtas;
    }

    /**
     * Find the doctor that is the best match for the requested service. Prioritize finding the doctor that is
     * specialized to provide this.service and can arrive in the shortest amount of time. However, if the closest
     * specialized doctor is 1hr or greater away, simply return the doctor that can arrive the fastest.
     * @return Return the best Doctor for the requested service and destination
     * @throws NoAvailableDoctorException If there are no available doctors
     */
    public Doctor match() throws NoAvailableDoctorException {
        Doctor closestDoctor = getClosestDoctor(availableDoctorEtas);
        Doctor closestDoctorWithService;

        Map<Doctor, Float> availableDoctorsWithServiceEtas = getDoctorsWithServiceEtas(availableDoctorEtas, service);

        try {
            closestDoctorWithService = getClosestDoctor(availableDoctorsWithServiceEtas);
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

    /**
     * Find the Doctor with the minimum value in doctorEtas
     *
     * @param doctorEtas Map from Doctors to times, that you want to find the closest of
     * @return Returns the closest Doctor in doctors to this.destination
     * @throws NoAvailableDoctorException If doctors is empty
     */
    private Doctor getClosestDoctor(Map<Doctor, Float> doctorEtas) throws NoAvailableDoctorException {
        if (doctorEtas.isEmpty()) {
            throw new NoAvailableDoctorException("There are no available doctors");
        }

        Doctor closestDoctor = doctorEtas.keySet().iterator().next();
        float shortestTime = doctorEtas.get(closestDoctor);
        float currentTime;

        for (Doctor doctor : doctorEtas.keySet()) {
            currentTime = doctorEtas.get(doctor);

            if (currentTime < shortestTime) {
                shortestTime = currentTime;
                closestDoctor = doctor;
            }
        }

        return closestDoctor;
    }

    /**
     * Filter a <Doctor, Float> Map to only include doctors qualified to provide a given service.
     *
     * @param doctorEtas A map from Doctors to their ETA from a location.
     * @param service The desired service you wish to filter for.
     * @return A map similar to doctorEtas, but only elements with a doctor qualified to provide service are included.
     * @throws NoAvailableDoctorException If doctorEtas is empty.
     */
    private Map<Doctor, Float> getDoctorsWithServiceEtas(Map<Doctor, Float> doctorEtas, Service service) throws NoAvailableDoctorException {
        if (doctorEtas.isEmpty()) {
            throw new NoAvailableDoctorException("There are no available doctors");
        }

        Map<Doctor, Float> doctorWithServiceEtas = new HashMap<>();

        for (Doctor doctor: doctorEtas.keySet()) {
            if (doctor.getQualifiedServices().contains(service)) {
                doctorWithServiceEtas.put(doctor, doctorEtas.get(doctor));
            }
        }

        return doctorWithServiceEtas;
    }
}