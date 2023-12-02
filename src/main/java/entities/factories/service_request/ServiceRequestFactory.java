package entities.factories.service_request;

import entities.Doctor;
import entities.Service;
import entities.ServiceRequest;
import entities.matchers.DoctorMatcher;
import use_case.CreateRequest.NoAvailableDoctorException;

import java.util.Date;

public class ServiceRequestFactory {
    /**
     * Create a service request given the necessary information.
     *
     * @param distanceCalculator Calculator for the distance between two locations.
     * @param etaCalculator Calculator for the eta between two locations.
     * @param travelCostCalculator Calculator for the travel cost between two locations.
     * @param doctorMatcher A way to match the current request with a doctor.
     * @param service The service requested.
     * @param destination Where the service is to be delivered.
     * @param urgencyLevel How urgent the request is (1 : low, 2 : medium, 3 : high)
     * @param creationTime When the request was created.
     * @return A service request consistent with the arguments provided.
     * @throws NoAvailableDoctorException If there are no available doctors.
     * @throws InvalidLocationException If either the destination or the doctor's location is invalid.
     */
    public static ServiceRequest create(DistanceCalculator distanceCalculator,
                                 EtaCalculator etaCalculator,
                                 TravelCostCalculator travelCostCalculator,
                                 DoctorMatcher doctorMatcher,
                                 Service service,
                                 String destination,
                                 int urgencyLevel,
                                 Date creationTime) throws NoAvailableDoctorException, InvalidLocationException, DataUnavailableException {
        Doctor doctor = doctorMatcher.match();
        float price = travelCostCalculator.getPrice(doctor.getLocation(), destination) + service.getPrice();
        float eta = etaCalculator.getEta(doctor.getLocation(), destination);
        float distance = distanceCalculator.getDistance(doctor.getLocation(), destination);

        return new ServiceRequest(creationTime, doctor, urgencyLevel, destination, service, price, eta, distance);
    }
}