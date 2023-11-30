package use_case.CreateRequest;

import entities.Patient;
import entities.Service;

import java.util.Date;

/**
 * Input data object that stores the necessary values to create a request.
 */
public class CreateRequestInputData {
    private final Date creationTime;
    private final int urgencyLevel;
    private final String destination;
    private final Service service;
    private final Patient patient;

    /**
     * Create a CreateRequestInputData object that contains the given values.
     *
     * @param creationTime The time at which the request was created.
     * @param urgencyLevel An integer value denoting how urgent the request is (1 being the least urgent, and 3 being the most).
     * @param destination Where the request is to be carried out.
     * @param service The service requested.
     * @param patient The patient who requested the service.
     */
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

    /**
     * @return An integer between 1 and 3 denoting the urgency level (1 being the least urgent)
     */
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
