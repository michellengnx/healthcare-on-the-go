package interface_adapter.HomeScreen;

import entities.Patient;
import entities.Service;

/**
 * An object used to store the user's input data when creating a request.
 */
public class HomeScreenState {
    private String patient;

    /**
     * Create a new CreateRequestState.
     */
    public HomeScreenState() {

    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}