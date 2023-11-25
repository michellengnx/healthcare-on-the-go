package interface_adapter.CreateRequest;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A view model used to store the CreateRequestView's labels and state. Also responsible for alerting the view of
 * changes in the state.
 */
public class CreateRequestViewModel extends ViewModel {
    public final String TITLE_LABEL = "Create Request";
    public final String URGENCY_LABEL = "Choose Urgency Level";
    public final String SERVICE_LABEL = "Choose Service";
    public final String DESTINATION_LABEL = "Choose Destination (Optional)";
    public final String CREATE_REQUEST_BUTTON_LABEL = "Create Request";
    public final String CANCEL_BUTTON_LABEL = "Cancel";
    private CreateRequestState state;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Create a CreateRequestViewModel object with a given patient.
     *
     * @param patientName The username of the patient creating the request.
     */
    public CreateRequestViewModel(String patientName) {
        super("create request");
        this.state = new CreateRequestState(patientName);
    }

    public void setState(CreateRequestState state) {
        this.state = state;
    }

    public CreateRequestState getState() {
        return state;
    }

    /**
     * Alert the Views in this.support of changes made to the state.
     */
    @Override
    public void firePropertyChanged() {
        this.support.firePropertyChange("state", null, this.state);
    }

    /**
     * Add a View that would like to listen for changes in the state.
     *
     * @param listener The View that would like to listen to the state stored in this object.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}