package use_case.CreateRequest;

import entities.Patient;
import entities.ServiceRequest;

public interface CreateRequestUserDataAccessInterface {
    public void saveRequest(Patient patient, ServiceRequest request);
}
