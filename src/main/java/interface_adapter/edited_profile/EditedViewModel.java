package interface_adapter.edited_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditedViewModel extends ViewModel {
    public final String TITLE_LABEL = "Edited View";

    private EditedState state = new EditedState();
    public static final String EXIT_BUTTON_LABEL = "Return to home screen";
    private String editedProfile;

    public EditedViewModel() {
        super("edited");
    }

    public void setState(EditedState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Edit Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EditedState getState() {
        return state;
    }

    public String getEditedProfile() {
        return editedProfile;
    }

    public void setEditedProfile(String editedProfile) {
        this.editedProfile = editedProfile;
    }
}
