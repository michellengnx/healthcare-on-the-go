package use_case.ResolveRequest;

import entities.ServiceRequest;
import org.example.src.entities.Patient;

/**
 * Methods to user data access object must implement for the resolve request interactor to function
 */
public interface ResolveRequestUserDataAccessInterface {
    /**
     * Mark a given request as completed.
     *
     * @param patient The patient whose request has been completed.
     * @param request The request to be marked as completed.
     */
    public void resolveRequest(Patient patient, ServiceRequest request);
}
