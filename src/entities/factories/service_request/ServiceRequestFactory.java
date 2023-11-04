package entities.factories.service_request;

import entities.Doctor;
import entities.Service;
import entities.ServiceRequest;

import java.util.Date;

public class ServiceRequestFactory {
    public ServiceRequest create(Date creationTime, Doctor doctor, int urgencyLevel, String destination, Service service, ServiceRequestFactoryApiAccessInterface apiAccessObject) {
        String doctorLocation = doctor.getLocation();
        float price = apiAccessObject.getPrice(doctorLocation, destination);
        float eta = apiAccessObject.getEta(doctorLocation, destination);
        float distance = apiAccessObject.getDistance(doctorLocation, destination);
        return new ServiceRequest(creationTime, doctor,urgencyLevel, destination, service, price, eta, distance);
    }
}
