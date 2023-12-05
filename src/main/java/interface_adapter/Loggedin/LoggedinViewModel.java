package interface_adapter.Loggedin;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the Logged-in View, handling data for the logged-in state.
 */
public class LoggedinViewModel extends ViewModel {
    public final String TITLE_LABEL = "Logged In View";

    private LoggedinState state = new LoggedinState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";
    private String loggedInUser;

    public LoggedinViewModel() {
        super("logged in");
    }

    /**
     * Sets the state of being logged in.
     *
     * @param state The state of being logged in to set.
     */
    public void setState(LoggedinState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoggedinState getState() {
        return state;
    }

    /**
     * Retrieves the username of the logged-in user.
     *
     * @return The username of the logged-in user.
     */
    public String getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Sets the username of the logged-in user.
     *
     * @param loggedInUser The username of the logged-in user to set.
     */
    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
