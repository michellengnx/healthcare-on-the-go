package org.example.src.use_case.edit_profile;

import java.util.ArrayList;

public class EditInteractor implements EditInputBoundary {

    final EditUserDataAccessInterface userDataAccessObject;
    final EditOutputBoundary editPresenter;

    public EditInteractor(EditUserDataAccessInterface userDataAccessInterface,
                          EditOutputBoundary editOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.editPresenter = editOutputBoundary;
    }

    @Override
    public void execute(EditInputData editInputData) {
        String username = editInputData.getUsername();
        String newUsername = editInputData.getNewUsername();
        String newPassword = editInputData.getNewPassword();
        String newEmail = editInputData.getNewEmail();
        String newPhoneNumber = editInputData.getNewPhoneNumber();
        String newInsurance = editInputData.getNewInsurance();

        if (userDataAccessObject.existsByName(newUsername)) {
            editPresenter.prepareFailView(newUsername + ": Account with this username already exists.");
        } else {
            String changes = userDataAccessObject.editProfile(username, newUsername, newPassword,
                    newEmail, newPhoneNumber, newInsurance);
            if (changes.isEmpty()) {
                editPresenter.prepareFailView("No edits were made to the user profile.");
            } else {
                EditOutputData editOutputData = new EditOutputData(changes, false);
                editPresenter.prepareSuccessView(editOutputData);
            }
        }
    }
}
