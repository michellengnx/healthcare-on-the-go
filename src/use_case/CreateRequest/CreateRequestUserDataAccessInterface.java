package use_case.CreateRequest;

import entities.Patient;
import entities.ServiceRequest;

/**
 * Methods that the user data access object must implement for the create request interactor to function properly.
 */
public interface CreateRequestUserDataAccessInterface {
    /**
     * Store a given request in a patient object.
     *
     * @param patient The patient in which the request is stored.
     * @param request The request to be stored within the patient.
     */
    public void saveRequest(Patient patient, ServiceRequest request);
}
