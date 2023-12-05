package interface_adapter.LockView;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the LockView, handling data for the lock screen.
 */
public class LockViewModel extends ViewModel {
    public final String TITLE_LABEL = "Lock Screen";


    public  final String LOGIN_BUTTON_LABEL = "Log in";
    public  final String SIGNUP_BUTTON_LABEL = "Sign up";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a LockViewModel instance.
     */
    public LockViewModel() {
        super("lock");
    }

    /**
     * Notifies listeners about property changes.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null,null);
    }

    /**
     * Adds a property change listener.
     *
     * @param listener The listener to be added.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

}
