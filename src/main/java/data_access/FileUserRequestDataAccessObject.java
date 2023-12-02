package data_access;

import entities.Patient;
import entities.ServiceRequest;
import use_case.CreateRequest.CreateRequestUserDataAccessInterface;

public class FileUserRequestDataAccessObject implements CreateRequestUserDataAccessInterface {
    FilePatientDataAccessObject filePatientDataAccessObject;
    FileRequestDataAccessObject fileRequestDataAccessObject;
    public FileUserRequestDataAccessObject(FilePatientDataAccessObject filePatientDataAccessObject,
                                           FileRequestDataAccessObject fileRequestDataAccessObject) {
        this.filePatientDataAccessObject = filePatientDataAccessObject;
        this.fileRequestDataAccessObject = fileRequestDataAccessObject;
    }

    @Override
    public void saveRequest(Patient patient, ServiceRequest request) {
        this.fileRequestDataAccessObject.addRequest(request, patient.getUsername());
    }

    @Override
    public Patient getPatient(String patientName) {
        return this.filePatientDataAccessObject.get(patientName);
    }
}
