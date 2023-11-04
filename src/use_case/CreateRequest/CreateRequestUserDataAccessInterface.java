package use_case.CreateRequest;

import entities.ServiceRequest;

public interface CreateRequestUserDataAccessInterface {
    public boolean saveRequest(ServiceRequest request);
}
