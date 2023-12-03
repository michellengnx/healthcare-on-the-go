package use_case.edit_profile;

import entities.PasswordValidator;
import entities.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Interactor responsible for handling the editing of a patient's profile.
 */
public class EditInteractor implements EditInputBoundary {

    final EditPatientDataAccessInterface patientDataAccessObject;
    final EditOutputBoundary editPresenter;

    /**
     * Constructs an EditInteractor.
     *
     * @param patientDataAccessInterface the data access object to retrieve and modify patient data.
     * @param editOutputBoundary the presenter to handle output for successful and failed edits.
     */
    public EditInteractor(EditPatientDataAccessInterface patientDataAccessInterface,
                          EditOutputBoundary editOutputBoundary) {
        this.patientDataAccessObject = patientDataAccessInterface;
        this.editPresenter = editOutputBoundary;
    }

    /**
     * Executes the edit operation based on the provided input data.
     *
     * @param editInputData The input data containing information for profile editing.
     */
    @Override
    public void execute(EditInputData editInputData) {
        String username = editInputData.getUsername();
        String password = editInputData.getPassword();
        String email = editInputData.getEmail();
        String phoneNumber = editInputData.getPhoneNumber();
        String insurance = editInputData.getInsurance();
        String emergencyName = editInputData.getEmergencyName();
        String emergencyNumber = editInputData.getEmergencyNumber();
        String emergencyRelationship = editInputData.getEmergencyRelationship();
        String creditCardNumber = editInputData.getCreditCardNumber();
        Integer cvv = editInputData.getCvv();
        String expirationDate = editInputData.getExpirationDate();
        String nameOnCard = editInputData.getNameOnCard();

        Patient patient = patientDataAccessObject.get(editInputData.getUsername());


        Integer[] changes = patientDataAccessObject.editProfile(username, password, email, phoneNumber, insurance,
                creditCardNumber, cvv, expirationDate, nameOnCard,
                emergencyName, emergencyNumber, emergencyRelationship);

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";

        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addPattern("^.*\\d.*$"); // contains a digit
        passwordValidator.addPattern("^.*[a-z].*$"); // contains lower case letter
        passwordValidator.addPattern("^.*[A-Z].*$"); // contains upper case letter
        passwordValidator.addPattern("^.*[@#$%^&+=].*$"); // contains special character case letter
        passwordValidator.addPattern("^.{8,}$"); // at least 8 characters

        if (!passwordValidator.validatePassword(password)) {
            editPresenter.prepareFailView("Password doesn't satisfy the necessary requirements.");
        } else if (noChanges(changes)) {
            editPresenter.prepareFailView("No changes have been made to the account.");
        } else {

            EditOutputData editOutputData = new EditOutputData(patient.getPassword(),
                    patient.getEmail(), patient.getPhoneNumber(), patient.getInsurance(),
                    patient.getCreditCard().getCreditCardNumber(), patient.getCreditCard().getCcv(), patient.getCreditCard().getExpirationDate(), patient.getCreditCard().getNameOnCard(),
                    patient.getEmergencyContact().getName(), patient.getEmergencyContact().getPhoneNumber(), patient.getEmergencyContact().getRelationship(),
                    false);
            editPresenter.prepareSuccessView(editOutputData);
        }
    }

    /**
     * Checks if any changes have been made.
     *
     * @param list The list of changes made during the edit operation.
     * @return True if no changes occurred, the list is only populated with zeros, otherwise false.
     */
    private boolean noChanges(Integer[] list) {
        for (Integer num: list) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
