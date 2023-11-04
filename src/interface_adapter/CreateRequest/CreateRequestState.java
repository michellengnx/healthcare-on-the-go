package interface_adapter.CreateRequest;

import entities.Patient;
import entities.Service;

public class CreateRequestState {
    private int urgencyLevel = 0;
    private String destination = null;
    private Service service = null;
    private final Patient patient;

    public CreateRequestState(Patient patient) {
        this.patient = patient;
    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public String getDestination() {
        return destination;
    }

    public Service getService() {
        return service;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setUrgencyLevel(int urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
