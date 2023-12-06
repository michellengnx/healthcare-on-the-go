package app;

import interface_adapter.LockView.LockController;
import interface_adapter.LockView.LockPresenter;
import interface_adapter.LockView.LockViewModel;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import use_case.Lock.LockInputBoundary;
import use_case.Lock.LockInteractor;
import use_case.Lock.LockOutputBoundary;
import view.LockView;

import javax.swing.*;
import java.io.IOException;

/**
 * Factory class to create the LockView and its dependencies.
 */
public class LockUseCaseFactory {

    /**
     * Creates a LockView instance with the necessary dependencies.
     *
     * @param viewManagerModel The view manager model.
     * @param lockViewModel    The lock view model.
     * @param signUpViewModel  The sign-up view model.
     * @param loginViewModel   The login view model.
     * @return The created LockView.
     */
    public static LockView create(ViewManagerModel viewManagerModel,
                                  LockViewModel lockViewModel,
                                  SignUpViewModel signUpViewModel,
                                  LoginViewModel loginViewModel) {
        LockController lockController = createLockUseCase(
                viewManagerModel,
                signUpViewModel,
                loginViewModel);

        try {
            return new LockView(lockViewModel, lockController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open image file.");
        }
        return null;
    }

    /**
     * Creates a LockController instance with the required dependencies.
     *
     * @param viewManagerModel The view manager model.
     * @param signUpViewModel  The sign-up view model.
     * @param loginViewModel   The login view model.
     * @return The created LockController.
     */
    private static LockController createLockUseCase(ViewManagerModel viewManagerModel,
                                                          SignUpViewModel signUpViewModel,
                                                          LoginViewModel loginViewModel) {

        LockOutputBoundary lockPresenter = new LockPresenter(
                viewManagerModel,
                signUpViewModel,
                loginViewModel);

        LockInputBoundary lockScreenInputBoundary = new LockInteractor(
                lockPresenter);

        return new LockController(lockScreenInputBoundary);
    }
}
