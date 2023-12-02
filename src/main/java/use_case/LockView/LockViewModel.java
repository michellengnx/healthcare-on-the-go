package use_case.LockView;

import view.LockView;

import java.beans.PropertyChangeSupport;

public class LockViewModel extends LockView {
    public final String TITLE_LABEL = "Lock Screen";


    public  final String LOGIN_BUTTON_LABEL = "Log in";
    public  final String SIGNUP_BUTTON_LABEL = "Sign up";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public LockViewModel(LockViewModel lockViewModel) {
        super(lockViewModel);

    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null,null);
    }

}
