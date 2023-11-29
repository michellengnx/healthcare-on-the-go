package use_case.SignUp;

import entities.Patient;
import entities.factories.user.PatientUserFactory;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public void execute(SignUpInputData signUpInputData) {
//        This check requires querying the csv file
        if (userDataAccessObject.existsByUsername(signUpInputData.getUsername())) {
            userPresenter.prepareFailView("Username already exists.");
        } else if (userDataAccessObject.existsByEmail(signUpInputData.getEmail())) {
            userPresenter.prepareFailView("Email already exists.");
        }

//        This check doesn't require querying the csv file and should be helper method for the use case
        else if (!passwordMatches(signUpInputData.getPassword(), signUpInputData.getRepeatPassword())) {
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

    private boolean passwordMatches(String password, String repeatPassword) {
        return Objects.equals(password, repeatPassword);
    }

    //    TODO: expand implementation
    private boolean isPasswordValid(String password) {
        // Example: Password must be at least 8 characters long
        return password.length() >= 8;
    }

    //    TODO: expand implementation

    private boolean isValidEmail(String email) {
        // Example: Simple email format check using regular expression
        String emailRegex = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$";
        return email.matches(emailRegex);
    }
}