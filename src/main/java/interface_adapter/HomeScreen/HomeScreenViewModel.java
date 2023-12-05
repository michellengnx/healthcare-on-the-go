package interface_adapter.HomeScreen;

import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomeScreenViewModel extends ViewModel {
    public final String DOCTOR_OTW_LABEL = "A doctor is on their way!";
    public final String EDIT_PROFILE_BUTTON_LABEL = "Edit Profile";
    public final String TITLE_LABEL = "Home Screen";
    public final String CREATE_REQUEST_BUTTON_LABEL = "Create Request";
    public final String VIEW_REQUESTS_BUTTON_LABEL = "View Requests";
    public final String LEAVE_REVIEW_BUTTON_LABEL = "Leave Review";
    public final String LOGOUT_BUTTON_LABEL = "Log out";
    private HomeScreenState state;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public HomeScreenViewModel() {
        super("home screen");
        this.state = new HomeScreenState();
    }

    public void setState(HomeScreenState state) {
        this.state = state;
    }

    public HomeScreenState getState() {
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
