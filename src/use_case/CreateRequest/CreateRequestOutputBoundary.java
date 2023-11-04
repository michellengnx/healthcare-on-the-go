package use_case.CreateRequest;

import entities.ServiceRequest;

public interface CreateRequestOutputBoundary {
    public void prepareSuccessView(ServiceRequest request);
    public void prepareFailView(String error);
}
