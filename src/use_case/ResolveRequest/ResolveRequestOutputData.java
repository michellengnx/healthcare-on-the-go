package use_case.ResolveRequest;

import entities.ServiceRequest;
import org.example.src.entities.Patient;

/**
 * Output data object that stores the a resolved request and corresponding patient.
 */
public class ResolveRequestOutputData {
    private final Patient patient;
    private final ServiceRequest request;

    /**
     * Create a ResolveRequestOutputData object that contains the given values.
     *
     * @param patient The patient whose request was resolved.
     * @param request The request that was resolved.
     */
    public ResolveRequestOutputData(Patient patient, ServiceRequest request) {
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
