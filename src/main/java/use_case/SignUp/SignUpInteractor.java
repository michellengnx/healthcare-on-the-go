package use_case.SignUp;

import entities.User;
import entities.factories.user.UserFactory;

import java.time.LocalDate;

public class SignUpInteractor implements SignUpInputBoundary {
    final SignUpUserDataAccessInterface userDataAccessObject;
    final SignUpOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignUpInteractor(SignUpUserDataAccessInterface signUpDataAccessInterface,
                            SignUpOutputBoundary signUpOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signUpDataAccessInterface;
        this.userPresenter = signUpOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignUpInputData signUpInputData) {
        if (userDataAccessObject.existsByUsername(signUpInputData.getUsername())) {
            userPresenter.prepareFailView("Username already exists.");
        } else if (userDataAccessObject.existsByEmail(signUpInputData.getEmail())) {
            userPresenter.prepareFailView("Email already exists.");
        }
        else if (userDataAccessObject.passwordDoesNotMatch(signUpInputData.getPassword(), signUpInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDate now = LocalDate.now();
            User user = userFactory.create(
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
            userDataAccessObject.save(user);

            SignUpOutputData signUpOutputData =
                    new SignUpOutputData(
                            user.getUsername(),
                            now.toString(),
                            false);
            userPresenter.prepareSuccessView(signUpOutputData);
        }
    }
}