package app;

import entities.factories.user.PatientUserFactory;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.Loggedin.LoggedinViewModel;
import interface_adapter.Login.LoginController;
import interface_adapter.Login.LoginPresenter;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.ReturnToLock.ReturnToLockController;
import interface_adapter.ViewManagerModel;

import use_case.Login.LoginInputBoundary;
import use_case.Login.LoginInteractor;
import use_case.Login.LoginOutputBoundary;
import use_case.Login.LoginUserDataAccessInterface;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            HomeScreenViewModel loggedinViewModel,
            LoginUserDataAccessInterface userDataAccessObject,
            ReturnToLockController returnToLockController) {

        try {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, loggedinViewModel, userDataAccessObject);
            return new LoginView(loginViewModel, loginController, returnToLockController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            HomeScreenViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);

        PatientUserFactory userFactory = new PatientUserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}
