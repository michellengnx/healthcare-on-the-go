package entities;

import java.util.Date;

public class ServiceRequestFactory {
    public ServiceRequest createRequest(User patient, Date creationTime, Doctor doctor, int urgencyLevel, String destination,
                                        Service service, float price, float eta, float distance) {
        return new ServiceRequest(patient, creationTime, doctor, urgencyLevel, destination, service, price, eta, distance);
    }
}
