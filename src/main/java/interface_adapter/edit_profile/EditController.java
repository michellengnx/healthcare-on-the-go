package interface_adapter.edit_profile;

import use_case.edit_profile.EditInputBoundary;
import use_case.edit_profile.EditInputData;

public class EditController {
    final EditInputBoundary editUseCaseInteractor;

    public EditController(EditInputBoundary editUseCaseInteractor) {
        this.editUseCaseInteractor = editUseCaseInteractor;

    }

    public void execute(String oldUsername, String username, String password, String email, String phoneNumber, String insurance,
                        String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                        String emergencyName, String emergencyNumber, String emergencyRelationship) {
        EditInputData editInputData = new EditInputData(oldUsername, username, password, email, phoneNumber, insurance,
                creditCardNumber, cvv, expirationDate, nameOnCard,
                emergencyName, emergencyNumber, emergencyRelationship);

        editUseCaseInteractor.execute(editInputData);
    }
}
