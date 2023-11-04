package use_case.CreateRequest;

import entities.Doctor;
import entities.Service;

import javax.print.Doc;
import java.util.List;

public class DoctorMatcher {
    Service service;
    String destination;
    CreateRequestDoctorDataAccessInterface doctorDataAccessObject;
    CreateRequestApiAccessInterface apiAccessObject;

    /**
     * Create a doctor matcher for a given service and destination
     * @param service The service being requested
     * @param destination The destination to which the doctor will travel
     * @param doctorDataAccessObject Data access object to source the doctors from
     * @param apiAccessObject Api access object to calculate ETA
     */
    public DoctorMatcher(Service service,
                         String destination,
                         CreateRequestDoctorDataAccessInterface doctorDataAccessObject,
                         CreateRequestApiAccessInterface apiAccessObject) {
        this.service = service;
        this.destination = destination;
        this.doctorDataAccessObject = doctorDataAccessObject;
        this.apiAccessObject = apiAccessObject;
    }

    /**
     * Find the doctor that is the best match for the requested service/destination. Prioritize finding the doctor
     * that is specialized to provide this.service and can arrive in the shortest amount of time. However, if the
     * closest specialized doctor is 1hr or greater away from this.destination, simply return the doctor that can arrive
     * the fastest.
     * @return Return the best Doctor for the requested service and destination
     * @throws NoAvailableDoctorException If there are no available doctors
     */
    public Doctor match() throws NoAvailableDoctorException {
        List<Doctor> availableDoctors = this.doctorDataAccessObject.getAvailableDoctors();
        List<Doctor> availableDoctorsWithService = this.doctorDataAccessObject.getAvailableDoctors(this.service);

        Doctor closestDoctor = getClosestDoctor(availableDoctors);
        Doctor closestDoctorWithService;

        try {
            closestDoctorWithService = getClosestDoctor(availableDoctorsWithService);
        } catch (NoAvailableDoctorException e) {
            return closestDoctor;
        }

        float distDoctorWithService = this.apiAccessObject.getDistance(closestDoctorWithService.getLocation(), this.destination);

        if (distDoctorWithService < 60) {
            return closestDoctorWithService;
        } else {
            return closestDoctor;
        }
    }

    /**
     * Find the closest (in terms of time) Doctor in doctors relative to this.destination
     * @param doctors Doctors you want to find the closest of
     * @return Returns the closest Doctor in doctors to this.destination
     * @throws NoAvailableDoctorException If doctors is empty
     */
    private Doctor getClosestDoctor(List<Doctor> doctors) throws NoAvailableDoctorException {
        if (doctors.isEmpty()) {
            throw new NoAvailableDoctorException("There are no available doctors");
        }

        Doctor closestDoctor = doctors.get(0);
        String doctorLocation = closestDoctor.getLocation();
        float shortestTime = this.apiAccessObject.getEta(doctorLocation, this.destination);
        float currentTime;

        for (Doctor doctor : doctors) {
            doctorLocation = doctor.getLocation();
            currentTime = this.apiAccessObject.getEta(doctorLocation, this.destination);

            if (currentTime < shortestTime) {
                shortestTime = currentTime;
                closestDoctor = doctor;
            }
        }

        return closestDoctor;
    }
}
