package entities.matchers;

import entities.Doctor;
import entities.Service;
import use_case.CreateRequest.NoAvailableDoctorException;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    /**
     * Find the Doctor with the minimum key, if there is a tie, return the first instance.
     *
     * @param doctorMap Map from Doctors to Floats, whose key you want to find the minimum value of.
     * @return Returns the Doctor that maps to the lowest float.
     * @throws NoAvailableDoctorException If doctorMap is empty.
     */
    public static Doctor minKey(Map<Doctor, Float> doctorMap) throws NoAvailableDoctorException {
        if (doctorMap.isEmpty()) {
            throw new NoAvailableDoctorException("There are no available doctors");
        }

        Doctor closestDoctor = doctorMap.keySet().iterator().next();
        float shortestTime = doctorMap.get(closestDoctor);
        float currentTime;

        for (Doctor doctor : doctorMap.keySet()) {
            currentTime = doctorMap.get(doctor);

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
     * @param doctorMap A map from Doctors to Floats.
     * @param service The desired service you wish to filter for.
     * @return A map similar to doctorMap, but only elements with a doctor qualified to provide service are included.
     * @throws NoAvailableDoctorException If doctorMap is empty.
     */
    public static Map<Doctor, Float> filterDoctorsWithService(Map<Doctor, Float> doctorMap, Service service) throws NoAvailableDoctorException {
        if (doctorMap.isEmpty()) {
            throw new NoAvailableDoctorException("There are no available doctors");
        }

        Map<Doctor, Float> doctorWithServiceEtas = new HashMap<>();

        for (Doctor doctor: doctorMap.keySet()) {
            if (doctor.getQualifiedServices().contains(service)) {
                doctorWithServiceEtas.put(doctor, doctorMap.get(doctor));
            }
        }

        return doctorWithServiceEtas;
    }
}
