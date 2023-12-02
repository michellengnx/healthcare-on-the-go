package use_case.CreateRequest;

import entities.Patient;
import entities.ServiceRequest;

/**
 * Output data object that stores the necessary values for the create request presenter.
 */
public class CreateRequestOutputData {
    private final ServiceRequest request;
    private final String patientName;
    private final String mapUrl;

    public CreateRequestOutputData(ServiceRequest request, String patientName, String mapUrl) {
        this.request = request;
        this.patientName = patientName;
        this.mapUrl = mapUrl;
    }

    public ServiceRequest getRequest() {
        return request;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMapUrl() {
        return mapUrl;
    }
}
