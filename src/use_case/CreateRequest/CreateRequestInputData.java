package use_case.CreateRequest;

import entities.Patient;
import entities.Service;

import java.util.Date;

public class CreateRequestInputData {
    private final Date creationTime;
    private final int urgencyLevel;
    private final String destination;
    private final Service service;
    private final Patient patient;

    public CreateRequestInputData(Date creationTime, int urgencyLevel, String destination, Service service, Patient patient) {
        this.creationTime = creationTime;
        this.urgencyLevel = urgencyLevel;
        this.destination = destination;
        this.service = service;
        this.patient = patient;
    }

    public Date getCreationTime() {
        return creationTime;
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
}
