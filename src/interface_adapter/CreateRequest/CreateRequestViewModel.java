package interface_adapter.CreateRequest;

import entities.Patient;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateRequestViewModel extends ViewModel {
    public final String URGENCY_LABEL = "Choose Urgency Level";
    public final String SERVICE_LABEL = "Choose Service";
    public final String DESTINATION_LABEL = "Choose Destination (Optional)";
    public final String CREATE_REQUEST_BUTTON_LABEL = "Create Request";
    public final String CANCEL_BUTTON_LABEL = "Cancel";
    private CreateRequestState state;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public CreateRequestViewModel(Patient patient) {
        super("create request");
        this.state = new CreateRequestState(patient);
    }

    public void setState(CreateRequestState state) {
        this.state = state;
    }

    public CreateRequestState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {
        this.support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
