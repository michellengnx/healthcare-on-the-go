package interface_adapter.LockView;

import interface_adapter.ViewModel;
import view.LockView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LockViewModel extends ViewModel {
    public final String TITLE_LABEL = "Lock Screen";


    public  final String LOGIN_BUTTON_LABEL = "Log in";
    public  final String SIGNUP_BUTTON_LABEL = "Sign up";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public LockViewModel() {
        super("lock");
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null,null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

}
