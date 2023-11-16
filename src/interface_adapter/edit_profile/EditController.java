package interface_adapter.edit_profile;


// do I need to import from signup?

import use_case.edit_profile.EditInputBoundary;
import use_case.edit_profile.EditInputData;

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
     */

    public void execute(String username, String password, String newParameter) {
        EditInputData editInputData = new EditInputData(username, password, newParameter);gi
        editUseCaseInteractor.execute(editInputData);
    }
}
