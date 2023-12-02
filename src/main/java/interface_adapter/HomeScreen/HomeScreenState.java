package interface_adapter.HomeScreen;

import entities.Patient;
import entities.Service;

/**
 * An object used to store the user's input data when creating a request.
 */
public class HomeScreenState {
    private String patient;
    private boolean activeRequest;
    private String imageUrl;

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

    public boolean isActiveRequest() {
        return activeRequest;
    }

    public void setActiveRequest(boolean activeRequest) {
        this.activeRequest = activeRequest;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}