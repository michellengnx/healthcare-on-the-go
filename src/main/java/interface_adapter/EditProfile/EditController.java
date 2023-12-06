package interface_adapter.EditProfile;

import use_case.EditProfile.EditInputBoundary;
import use_case.EditProfile.EditInputData;

/**
 * Controller responsible for handling edit profile requests.
 */
public class EditController {
    final EditInputBoundary editUseCaseInteractor;

    /**
     * Constructs an EditController with an EditInputBoundary.
     *
     * @param editUseCaseInteractor The interactor handling the edit profile use case.
     */
    public EditController(EditInputBoundary editUseCaseInteractor) {
        this.editUseCaseInteractor = editUseCaseInteractor;

    }

    /**
     * Executes the edit profile action with the provided parameters.
     *
     * @param username the username associated with the user's profile (not editable).
     * @param password the new password for the patient.
     * @param email the new email for the patient.
     * @param phoneNumber the new phone number for the patient.
     * @param insurance the new insurance information for the patient.
     * @param creditCardNumber the new credit card number for the patient.
     * @param cvv the new CVV for the patient's credit card.
     * @param expirationDate the new expiration date for the patient's credit card.
     * @param nameOnCard the new name on the credit card for the patient.
     * @param emergencyName the new emergency contact name for the patient.
     * @param emergencyNumber the new emergency contact number for the patient.
     * @param emergencyRelationship the new relationship with the emergency contact for the patient.
     */
    public void execute(String username, String password, String email, String phoneNumber, String insurance,
                        String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                        String emergencyName, String emergencyNumber, String emergencyRelationship) {
        EditInputData editInputData = new EditInputData(username, password, email, phoneNumber, insurance,
                creditCardNumber, cvv, expirationDate, nameOnCard,
                emergencyName, emergencyNumber, emergencyRelationship);

        editUseCaseInteractor.execute(editInputData);
    }
}
