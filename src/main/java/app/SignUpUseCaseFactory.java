package app;


import data_access.FilePatientDataAccessObject;
import entities.factories.user.UserFactory;
import interface_adapter.SignUp.SignUpController;
import interface_adapter.SignUp.SignUpPresenter;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import use_case.SignUp.SignUpInputBoundary;
import use_case.SignUp.SignUpInteractor;
import use_case.SignUp.SignUpOutputBoundary;
import use_case.SignUp.SignUpUserDataAccessInterface;
import view.SignUpView;

import javax.swing.*;
import java.io.IOException;

public class SignUpUseCaseFactory {

    /** Prevent instantiation. */
    private SignUpUseCaseFactory() {}

    public static SignUpView create(
            ViewManagerModel viewManagerModel, SignUpViewModel signUpViewModel, FilePatientDataAccessObject userDataAccessObject) {

        try {
            SignUpController signUpController = createUserSignUpUseCase(viewManagerModel, signUpViewModel, userDataAccessObject);
            return new SignUpView(signUpController, signUpViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }


    private static SignUpController createUserSignUpUseCase(ViewManagerModel viewManagerModel, SignUpViewModel signUpViewModel, SignUpUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignUpOutputBoundary signUpOutputBoundary = new SignUpPresenter(viewManagerModel, signUpViewModel);

        UserFactory userFactory = new UserFactory();

        SignUpInputBoundary userSignUpInteractor = new SignUpInteractor(
                userDataAccessObject, signUpOutputBoundary, userFactory);

        return new SignUpController(userSignUpInteractor);
    }
}
