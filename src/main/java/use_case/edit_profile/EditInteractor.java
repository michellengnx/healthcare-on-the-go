package use_case.edit_profile;

import entities.Patient;

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

        // Assume user is already logged in, therefore, do not need to check if the user exists
        Integer changes = patientDataAccessObject.editProfile(username, password, email, phoneNumber, insurance);
        if (changes == 0) {
            editPresenter.prepareFailView("No changes have been made to the account");
        } else {
            Patient patient = patientDataAccessObject.get(editInputData.getUsername());

            EditOutputData editOutputData = new EditOutputData(patient.getUsername(), patient.getPassword(),
                    patient.getEmail(), patient.getPhoneNumber(), patient.getInsurance(),false);
                editPresenter.prepareSuccessView(editOutputData);
            }
        }
}
