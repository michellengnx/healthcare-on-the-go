package use_case.edit_profile;

import entities.Patient;
import entities.User;

import java.util.ArrayList;

public class EditInteractor implements EditInputBoundary {

    final EditUserDataAccessInterface patientDataAccessObject;
    final EditOutputBoundary editPresenter;

    public EditInteractor(EditUserDataAccessInterface patientDataAccessInterface,
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

        // Assume user is already logged in, therefore, do not need to check if the user exists
        Integer changes = patientDataAccessObject.editProfile(username, password, email, phoneNumber, insurance);
        if (changes == 0) {
            editPresenter.prepareFailView("No changes have been made to the account");
        } else {
            // should all users mentioned here be patient instead?
            Patient patient = patientDataAccessObject.get(editInputData.getUsername());

            EditOutputData editOutputData = new EditOutputData(patient.getUsername(), false);
                editPresenter.prepareSuccessView(editOutputData);
            }
        }
}
