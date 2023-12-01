package interface_adapter.HomeScreen;

import entities.Patient;
import entities.Service;

/**
 * An object used to store the user's input data when creating a request.
 */
public class HomeScreenState {
    private Patient patient;

    /**
     * Create a new CreateRequestState with a given patient.
     *
     */
    public HomeScreenState() {

    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}