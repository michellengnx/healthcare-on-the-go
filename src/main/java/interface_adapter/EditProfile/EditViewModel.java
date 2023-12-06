package interface_adapter.EditProfile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel responsible for managing the state of the Edit Profile view.
 */
public class EditViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Edit View";
    public static final String SUBHEADING_MAIN_LABEL = "Main Profile Details";
    public static final String NEW_USERNAME_LABEL = "Enter username";
    public static final String NEW_PASSWORD_LABEL = "Enter new password";
    public static final String NEW_EMAIL_LABEL = "Enter new email";
    public static final String NEW_PHONE_NUMBER_LABEL = "Enter new phone number";
    public static final String NEW_INSURANCE_LABEL = "Enter new insurance";
    public static final String SUBHEADING_CREDIT_CARD_LABEL = "Credit Card Details";
    public static final String NEW_CREDIT_CARD_NUMBER_LABEL = "Enter new credit card number";
    public static final String NEW_CVV_LABEL = "Enter new CVV";
    public static final String NEW_EXPIRATION_DATE_LABEL = "Enter new expiration date";
    public static final String NEW_NAME_ON_CARD_LABEL = "Enter new name on card";
    public static final String SUBHEADING_EMERGENCY_CONTACT_LABEL = "Emergency Contact Details";
    public static final String NEW_EMERGENCY_NAME_LABEL = "Enter new name of emergency contact";
    public static final String NEW_EMERGENCY_NUMBER_LABEL = "Enter new emergency contact's phone number";
    public static final String NEW_EMERGENCY_RELATIONSHIP_LABEL = "Enter new relationship with emergency contact";

    public static final String EDIT_PROFILE_BUTTON_LABEL = "Edit profile";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    // Represents the state of the Edit Profile view
    private EditState state = new EditState();

    /**
     * Constructs an EditViewModel object.
     */
    public EditViewModel() {
        super("edit");
    }

    /**
     * Sets the state of the Edit Profile view.
     *
     * @param state The EditState object representing the view state.
     */
    public void setState(EditState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies listeners about the change in the state of the view.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to monitor changes in the view state.
     *
     * @param listener The PropertyChangeListener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state of the Edit Profile view.
     *
     * @return The current EditState representing the view's state.
     */
    public EditState getState() {
        return state;
    }
}
