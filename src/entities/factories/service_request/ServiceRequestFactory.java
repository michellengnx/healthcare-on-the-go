package entities.factories.service_request;

import entities.Doctor;
import entities.Service;
import entities.ServiceRequest;

import java.util.Date;

public class ServiceRequestFactory {
    public ServiceRequest create(Date creationTime, Doctor doctor, int urgencyLevel, String destination, Service service, float price, float eta, float distance) {
        return new ServiceRequest(creationTime, doctor, urgencyLevel, destination, service, price, eta, distance);
    }
}
