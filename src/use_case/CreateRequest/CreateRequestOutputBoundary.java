package use_case.CreateRequest;

import entities.ServiceRequest;

public interface CreateRequestOutputBoundary {
    public void prepareSuccessView(CreateRequestOutputData response);
    public void prepareFailView(String error);
}
