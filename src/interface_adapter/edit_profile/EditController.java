package org.example.src.interface_adapter.edit_profile;

import org.example.src.use_case.edit_profile.EditInputData;
import org.example.src.use_case.edit_profile.EditInputBoundary;
// do I need to import from signup?

import java.util.Date;

public class EditController {
    final EditInputBoundary editUseCaseInteractor;

    public EditController(EditInputBoundary editUseCaseInteractor) {
        this.editUseCaseInteractor = editUseCaseInteractor;

    }
    // would this be newParameterName, rather than just parameterName?
    /**
     * Execute the edit profile use case, passing an input data object created using the arguments to the method.
     * @param username: the current username of the user.
     * @param newUsername: the new username the user wants to have associated with their profile.
     * @param newPassword: new password the user wants to have associated with their profile.
     * @param newEmail: new email the user wants to have associated with their profile.
     * @param newPhoneNumber: new phone number the user wants to have associated with their profile.
     * @param newInsurance: new insurance the user wants to have associated with their profile.
     */

    public void execute(String username, String newUsername, String newPassword, String newEmail,
                        String newPhoneNumber,String newInsurance) {
        EditInputData editInputData = new EditInputData(
                username, newUsername, newPassword, newEmail, newPhoneNumber, newInsurance);

        editUseCaseInteractor.execute(editInputData);
    }
}
