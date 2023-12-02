
package interface_adapter.SignUp;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SignUpViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Sign Up View";
    public static final String SUBHEADING_MAIN_LABEL = "Main Profile Details";
    public static final String USERNAME_LABEL = "Choose username";
    public static final String PASSWORD_LABEL = "Choose password";
    public static final String REPEAT_PASSWORD_LABEL = "Enter password again";
    public static final String EMAIL_LABEL = "Email";
    public static final String PHONE_NUMBER_LABEL = "Phone Number";
    public static final String GENDER_LABEL = "Gender";
    public static final String INSURANCE_LABEL = "Insurance";
    public static final String BIRTHDAY_LABEL = "Birthday";
    public static final String SUBHEADING_CREDIT_CARD_LABEL = "Credit Card Details";
    public static final String CREDIT_CARD_NUMBER_LABEL = "Credit Card Number";
    public static final String CCV_LABEL = "CCV";
    public static final String EXPIRATION_DATE_LABEL = "Expiration Date";
    public static final String NAME_ON_CARD_LABEL = "Name on Card";
    public static final String SUBHEADING_EMERGENCY_CONTACT_LABEL = "Emergency Contact Details";
    public static final String CONTACT_NAME_LABEL = "Contact Name";
    public static final String CONTACT_PHONE_NUMBER_LABEL = "Contact Phone Number";
    public static final String CONTACT_RELATIONSHIP_LABEL = "Contact Relationship";




    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private SignUpState state = new SignUpState();

    public SignUpViewModel() {
        super("sign up");
    }

    public void setState(SignUpState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("signup", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SignUpState getState() {
        return state;
    }
}
