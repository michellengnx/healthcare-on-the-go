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

/**
 * Factory class to create the LoginView and its dependencies.
 */
public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

    /**
     * Creates a LoginView instance with the necessary dependencies.
     *
     * @param viewManagerModel      The view manager model.
     * @param loginViewModel       The login view model.
     * @param loggedinViewModel    The logged-in view model.
     * @param userDataAccessObject The user data access object.
     * @param returnToLockController The return to lock controller.
     * @return The created LoginView.
     */
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

    /**
     * Creates a LoginController instance with the required dependencies.
     *
     * @param viewManagerModel      The view manager model.
     * @param loginViewModel       The login view model.
     * @param loggedInViewModel    The logged-in view model.
     * @param userDataAccessObject The user data access object.
     * @return The created LoginController.
     * @throws IOException If there's an issue with file I/O.
     */
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
