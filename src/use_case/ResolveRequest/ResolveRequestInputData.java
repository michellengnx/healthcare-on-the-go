package use_case.ResolveRequest;

import entities.ServiceRequest;
import entities.Patient;

/**
 * Input data object that stores the necessary values to resolve a request.
 */
public class ResolveRequestInputData {
    private final Patient patient;
    private final ServiceRequest request;

    /**
     * Create a ResolveRequestInputData object that contains the given values.
     *
     * @param patient The patient whose request is to be resolved.
     * @param request The request to be resolved.
     */
    public ResolveRequestInputData(Patient patient, ServiceRequest request) {
        this.patient = patient;
        this.request = request;
    }

    public Patient getPatient() {
        return patient;
    }

    public ServiceRequest getRequest() {
        return request;
    }
}
