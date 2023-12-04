package interface_adapter.ViewRequest;

import entities.ServiceRequest;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * Represents the ViewModel for managing view-specific data related to viewing service requests.
 */
public class ViewRequestViewModel extends ViewModel {

    public ViewRequestState getViewRequestState() {
        return viewRequestState;
    }

    public void setViewRequestState(ViewRequestState viewRequestState) {
        this.viewRequestState = viewRequestState;
    }

    private ViewRequestState viewRequestState;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Initializes a new instance of ViewRequestViewModel and sets up the initial state.
     */
    public ViewRequestViewModel() {
        super("view requests");
        this.viewRequestState = new ViewRequestState();

    }

    /**
     * Retrieves the current state of the ViewRequestViewModel.
     *
     * @return The current ViewRequestState.
     */
    public ViewRequestState getState() {
        return this.viewRequestState;
    }

    /**
     * Updates the state of the ViewRequestViewModel with a new ViewRequestState.
     *
     * @param newState The new ViewRequestState to set.
     */
    public void setState(ViewRequestState newState) {
        this.viewRequestState = newState;
    }

    /**
     * Alert the Views in this.support of changes made to the state.
     */
    @Override
    public void firePropertyChanged() {
        this.support.firePropertyChange("state", null, this.viewRequestState);
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