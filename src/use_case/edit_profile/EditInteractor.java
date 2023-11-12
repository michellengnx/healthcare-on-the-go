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

        // remember to implement this method in FileUserDataAcessObject!
        if (userDataAccessObject.existsByName(newUsername)) {
            editPresenter.prepareFailView(newUsername + ": Account with this username already exists.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            String email = userDataAccessObject.get(username).getEmail();
            String phoneNumber = userDataAccessObject.get(username).getPhoneNumber();
            String insurance = userDataAccessObject.get(username).getInsurance();

            // if at least one of these parameters have changed from the original, prepare success view
            if ((!newPassword.equals(pwd)) || (!newEmail.equals(email)) ||
                    (!newPhoneNumber.equals(phoneNumber)) || (!newInsurance.equals(insurance))) {
                // remember to implement this method in fileuserdataaccessobject!
                String changes = userDataAccessObject.editProfile();
                EditOutputData editOutputData = new EditOutputData(changes, false);
            } else {
                editPresenter.prepareFailView("Password has not changed for" + username + ".");
                editPresenter.prepareSuccessView(editOutputData);
            }
        }
    }
}
