package use_case.edit_profile;

import entities.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditInteractor implements EditInputBoundary {

    final EditPatientDataAccessInterface patientDataAccessObject;
    final EditOutputBoundary editPresenter;

    public EditInteractor(EditPatientDataAccessInterface patientDataAccessInterface,
                          EditOutputBoundary editOutputBoundary) {
        this.patientDataAccessObject = patientDataAccessInterface;
        this.editPresenter = editOutputBoundary;
    }

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

        Integer[] changes = patientDataAccessObject.editProfile(username, password, email, phoneNumber, insurance,
                creditCardNumber, cvv, expirationDate, nameOnCard,
                emergencyName, emergencyNumber, emergencyRelationship);

        if (changes[0] == -1) {
            editPresenter.prepareFailView("Username already exists.");
        } else if (changes[1] == -1) {
            editPresenter.prepareFailView("Password doesn't satisfy the necessary requirements.");
        } else if (Arrays.stream(changes).distinct().count() <= 1) {
            editPresenter.prepareFailView("No changes have been made to the account.");
        } else {
            Patient patient = patientDataAccessObject.get(editInputData.getUsername());

            EditOutputData editOutputData = new EditOutputData(patient.getUsername(), patient.getPassword(),
                    patient.getEmail(), patient.getPhoneNumber(), patient.getInsurance(),
                    patient.getCreditCard().getCreditCardNumber(), patient.getCreditCard().getCcv(), patient.getCreditCard().getExpirationDate(), patient.getCreditCard().getNameOnCard(),
                    patient.getEmergencyContact().getName(), patient.getEmergencyContact().getPhoneNumber(), patient.getEmergencyContact().getRelationship(),
                    false);
            editPresenter.prepareSuccessView(editOutputData);
        }
    }
}
