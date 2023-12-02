package use_case.CreateRequest;

import entities.Patient;
import entities.ServiceRequest;

/**
 * Output data object that stores the necessary values for the create request presenter.
 */
public class CreateRequestOutputData {
    private final ServiceRequest request;
    private final String patientName;

    public CreateRequestOutputData(ServiceRequest request, String patientName) {
        this.request = request;
        this.patientName = patientName;
    }

    public ServiceRequest getRequest() {
        return request;
    }

    public String getPatientName() {
        return patientName;
    }
}
