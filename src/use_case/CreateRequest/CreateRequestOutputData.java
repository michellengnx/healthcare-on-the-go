package use_case.CreateRequest;

import entities.Patient;
import entities.ServiceRequest;

/**
 * Output data object that stores the necessary values for the create request presenter.
 */
public class CreateRequestOutputData {
    private final ServiceRequest request;
    private final Patient patient;

    public CreateRequestOutputData(ServiceRequest request, Patient patient) {
        this.request = request;
        this.patient = patient;
    }

    public ServiceRequest getRequest() {
        return request;
    }

    public Patient getPatient() {
        return patient;
    }
}
