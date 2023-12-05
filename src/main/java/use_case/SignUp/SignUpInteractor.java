package use_case.SignUp;

import entities.PasswordValidator;
import entities.Patient;
import entities.factories.user.PatientUserFactory;
import use_case.SignUp.validators.InputValidation;

import java.time.LocalDate;

/**
 * Handles the sign-up use case logic.
 */
public class SignUpInteractor implements SignUpInputBoundary {
    final SignUpUserDataAccessInterface userDataAccessObject;
    final SignUpOutputBoundary userPresenter;
    final PatientUserFactory patientUserFactory;

    public SignUpInteractor(SignUpUserDataAccessInterface signUpDataAccessInterface,
                            SignUpOutputBoundary signUpOutputBoundary,
                            PatientUserFactory patientUserFactory) {
        this.userDataAccessObject = signUpDataAccessInterface;
        this.userPresenter = signUpOutputBoundary;
        this.patientUserFactory = patientUserFactory;
    }

    /**
     * Executes the sign-up process based on the provided sign-up input data.
     *
     * @param signUpInputData The data containing user sign-up information.
     */
    @Override
    public void execute(SignUpInputData signUpInputData) {
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.addPattern("^.*\\d.*$"); // contains a digit
        passwordValidator.addPattern("^.*[a-z].*$"); // contains lower case letter
        passwordValidator.addPattern("^.*[A-Z].*$"); // contains upper case letter
        passwordValidator.addPattern("^.*[!@#$%^&+=].*$"); // contains special character case letter
        passwordValidator.addPattern("^.{8,}$"); // at least 8 characters

//        This check requires querying the csv file
        if (userDataAccessObject.existsByUsername(signUpInputData.getUsername())) {
            userPresenter.prepareFailView("Username already exists.");
        } else if (userDataAccessObject.existsByEmail(signUpInputData.getEmail())) {
            userPresenter.prepareFailView("Email already exists.");
        } else if (!passwordValidator.validatePassword(signUpInputData.getPassword())) {
            userPresenter.prepareFailView("Password doesn't satisfy the necessary requirements.\nMust contain:\n- a digit\n- a lower case letter\n- an upper case letter\n- a special character (!@#$%^&)\nMust also be at least 8 characters");
        }

//        This check doesn't require querying the csv file and should be helper method for the use case
        else if (!InputValidation.passwordMatches(signUpInputData.getPassword(), signUpInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDate now = LocalDate.now();
            Patient patient = patientUserFactory.create(
                    signUpInputData.getUsername(),
                    signUpInputData.getPassword(),
                    signUpInputData.getEmail(),
                    signUpInputData.getPhoneNumber(),
                    signUpInputData.getGender(),
                    signUpInputData.getInsurance(),
                    signUpInputData.getBirthday(),
                    signUpInputData.getCreditCardNumber(),
                    signUpInputData.getCcv(),
                    signUpInputData.getExpirationDate(),
                    signUpInputData.getNameOnCard(),
                    signUpInputData.getContactName(),
                    signUpInputData.getContactPhoneNumber(),
                    signUpInputData.getContactRelationship());

            userDataAccessObject.save(patient);

            SignUpOutputData signUpOutputData =
                    new SignUpOutputData(
                            patient.getUsername(),
                            now.toString(),
                            false);
            userPresenter.prepareSuccessView(signUpOutputData);
        }
    }


}