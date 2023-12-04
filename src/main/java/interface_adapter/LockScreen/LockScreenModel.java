package interface_adapter.LockScreen;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LockScreenModel extends ViewModel {
    public final String TITLE_LABEL = "Lock Screen";


    public  final String LOGIN_BUTTON_LABEL = "Log in";
    public  final String SIGNUP_BUTTON_LABEL = "Sign up";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public LockScreenModel() {
        super("lock");
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null,null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

}
