package data_access;

import entities.Patient;
import entities.ServiceRequest;
import use_case.CreateRequest.CreateRequestUserDataAccessInterface;

/**
 * Manages the data access for creating user requests, linking to both patient and service requests.
 */
public class FileUserRequestDataAccessObject implements CreateRequestUserDataAccessInterface {
    FilePatientDataAccessObject filePatientDataAccessObject;
    FileRequestDataAccessObject fileRequestDataAccessObject;

    /**
     * Constructs a FileUserRequestDataAccessObject with dependencies.
     *
     * @param filePatientDataAccessObject The data access object for patient information.
     * @param fileRequestDataAccessObject The data access object for service requests.
     */
    public FileUserRequestDataAccessObject(FilePatientDataAccessObject filePatientDataAccessObject,
                                           FileRequestDataAccessObject fileRequestDataAccessObject) {
        this.filePatientDataAccessObject = filePatientDataAccessObject;
        this.fileRequestDataAccessObject = fileRequestDataAccessObject;
    }

    /**
     * Saves a service request for a patient.
     *
     * @param patient The patient for whom the request is being saved.
     * @param request The service request to be saved.
     */
    @Override
    public void saveRequest(Patient patient, ServiceRequest request) {
        this.fileRequestDataAccessObject.addRequest(request, patient.getUsername());
    }

    /**
     * Retrieves patient information based on the patient's name.
     *
     * @param patientName The name of the patient.
     * @return The patient object associated with the provided name.
     */
    @Override
    public Patient getPatient(String patientName) {
        return this.filePatientDataAccessObject.get(patientName);
    }
}
