package interface_adapter.edit_profile;

import use_case.edit_profile.EditInputBoundary;
import use_case.edit_profile.EditInputData;

public class EditController {
    final EditInputBoundary editUseCaseInteractor;

    public EditController(EditInputBoundary editUseCaseInteractor) {
        this.editUseCaseInteractor = editUseCaseInteractor;

    }

    public void execute(String username, String password, String email, String phoneNumber, String insurance) {
        EditInputData editInputData = new EditInputData(username, password, email, phoneNumber, insurance);

        editUseCaseInteractor.execute(editInputData);
    }
}
