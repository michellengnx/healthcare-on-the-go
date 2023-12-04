package app;


import data_access.FilePatientDataAccessObject;
import entities.factories.user.PatientUserFactory;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.ReturnToLock.ReturnToLockController;
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

/**
 * Factory class to create the SignUpView and its dependencies.
 */
public class SignUpUseCaseFactory {

    /** Prevent instantiation. */
    private SignUpUseCaseFactory() {}

    /**
     * Creates a SignUpView instance with the necessary dependencies.
     *
     * @param viewManagerModel     The view manager model.
     * @param signUpViewModel     The sign-up view model.
     * @param loginViewModel      The login view model.
     * @param userDataAccessObject The user data access object.
     * @param returnToLockController The return to lock controller.
     * @return The created SignUpView.
     */
    public static SignUpView create(
            ViewManagerModel viewManagerModel, SignUpViewModel signUpViewModel, LoginViewModel loginViewModel, FilePatientDataAccessObject userDataAccessObject, ReturnToLockController returnToLockController) {

        try {
            SignUpController signUpController = createUserSignUpUseCase(viewManagerModel,  signUpViewModel, loginViewModel, userDataAccessObject);
            return new SignUpView(signUpController, signUpViewModel, returnToLockController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Creates a SignUpController instance with the required dependencies.
     *
     * @param viewManagerModel      The view manager model.
     * @param signUpViewModel      The sign-up view model.
     * @param loginViewModel       The login view model.
     * @param userDataAccessObject The user data access object.
     * @return The created SignUpController.
     * @throws IOException If there's an issue with file I/O.
     */
    private static SignUpController createUserSignUpUseCase(ViewManagerModel viewManagerModel, SignUpViewModel signUpViewModel,  LoginViewModel loginViewModel, SignUpUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignUpOutputBoundary signUpOutputBoundary = new SignUpPresenter(viewManagerModel, signUpViewModel, loginViewModel);

        PatientUserFactory patientUserFactory = new PatientUserFactory();

        SignUpInputBoundary userSignUpInteractor = new SignUpInteractor(
                userDataAccessObject, signUpOutputBoundary, patientUserFactory);

        return new SignUpController(userSignUpInteractor);
    }
}
