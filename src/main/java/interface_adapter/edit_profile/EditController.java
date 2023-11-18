package interface_adapter.edit_profile;

import use_case.edit_profile.EditInputBoundary;
import use_case.edit_profile.EditInputData;

public class EditController {
    final EditInputBoundary editUseCaseInteractor;

    public EditController(EditInputBoundary editUseCaseInteractor) {
        this.editUseCaseInteractor = editUseCaseInteractor;

    }
    // would this be newParameterName, rather than just parameterName?

    public void execute(String username, String newUsername, String newPassword,
                        String newInsurance, String newEmail, String newPhoneNumber) {
        EditInputData editInputData = new EditInputData(username, newUsername, newPassword,
                newInsurance, newEmail, newPhoneNumber);
        editUseCaseInteractor.execute(editInputData);
    }
}
