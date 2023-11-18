package use_case.edit_profile;

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

        Integer changes = userDataAccessObject.editProfile(username, newUsername, newPassword,
                newInsurance, newEmail, newPhoneNumber);
        if (changes == 0) {
            editPresenter.prepareFailView("No changes have been made to the account");
        } else {
            EditOutputData editOutputData = new EditOutputData(username, false);
                editPresenter.prepareSuccessView(editOutputData);
            }
        }
    }
}
