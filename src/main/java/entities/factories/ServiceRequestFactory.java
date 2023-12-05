package entities.factories;

import entities.Doctor;
import entities.Service;
import entities.ServiceRequest;
import entities.User;

import java.util.Date;

public class ServiceRequestFactory {
    public ServiceRequest createRequest(User patient, Date creationTime, Doctor doctor, int urgencyLevel, String destination,
                                        Service service, float price, float eta, float distance) {
        return new ServiceRequest(creationTime, doctor, urgencyLevel, destination, service, price, eta, distance);
    }
}
