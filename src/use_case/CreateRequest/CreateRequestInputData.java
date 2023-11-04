package use_case.CreateRequest;

import entities.Service;

import java.util.Date;

public class CreateRequestInputData {
    Date creationTime;
    int urgencyLevel;
    String destination;
    Service service;

    public CreateRequestInputData(Date creationTime, int urgencyLevel, String destination, Service service) {
        this.creationTime = creationTime;
        this.urgencyLevel = urgencyLevel;
        this.destination = destination;
        this.service = service;
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
}
