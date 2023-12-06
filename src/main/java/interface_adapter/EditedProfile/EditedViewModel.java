package interface_adapter.EditedProfile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel responsible for managing the state of the Edited Profile view.
 */
public class EditedViewModel extends ViewModel {
    public final String TITLE_LABEL = "Edited View";

    private EditedState state = new EditedState();
    public static final String EXIT_BUTTON_LABEL = "Home";
    private String editedProfile;

    /**
     * Constructs an EditedViewModel object initializing it with a specific identifier.
     */
    public EditedViewModel() {
        super("edited");
    }

    /**
     * Sets the state of the Edited Profile view.
     *
     * @param state The EditedState object representing the view's state.
     */
    public void setState(EditedState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies listeners about the change in the view's state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to monitor changes in the view's state.
     *
     * @param listener The PropertyChangeListener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state of the Edited Profile view.
     *
     * @return The current EditedState representing the view's state.
     */
    public EditedState getState() {
        return state;
    }

    /**
     * Retrieves the edited profile information.
     *
     * @return The edited profile information.
     */
    public String getEditedProfile() {
        return editedProfile;
    }

    /**
     * Sets the edited profile information.
     *
     * @param editedProfile The edited profile information to set.
     */
    public void setEditedProfile(String editedProfile) {
        this.editedProfile = editedProfile;
    }
}
