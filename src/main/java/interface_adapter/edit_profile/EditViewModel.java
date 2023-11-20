package interface_adapter.edit_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditViewModel extends ViewModel {

    public final String TITLE_LABEL = "Edit View";
    // when are these labels used?
    public static final String NEW_USERNAME_LABEL = "Choose new username";
    public static final String NEW_PASSWORD_LABEL = "Choose new password";
    public static final String NEW_EMAIL_LABEL = "Enter new email";
    public static final String NEW_PHONE_NUMBER_LABEL = "Enter new phone number";
    public static final String NEW_INSURANCE_LABEL = "Enter new insurance";

    public static final String EDIT_PROFILE_BUTTON_LABEL = "Edit profile";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String CLEAR_BUTTON_LABEL = "Clear";

    // all the fields are empty here
    private EditState state = new EditState();

    public EditViewModel() {
        super("edit");
    }

    public void setState(EditState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EditState getState() {
        return state;
    }
}
