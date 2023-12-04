package app;

import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenController;
import interface_adapter.HomeScreen.HomeScreenPresenter;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.LockView.LockController;
import interface_adapter.LockView.LockPresenter;
import interface_adapter.LockView.LockViewModel;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import interface_adapter.edit_profile.EditViewModel;
import use_case.HomeScreen.HomeScreenInputBoundary;
import use_case.HomeScreen.HomeScreenInteractor;
import use_case.HomeScreen.HomeScreenOutputBoundary;
import use_case.LockView.LockInputBoundary;
import use_case.LockView.LockInteractor;
import use_case.LockView.LockOutputBoundary;
import view.HomeScreenView;
import view.LockView;

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
        return new LockView(lockViewModel, lockController);

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

        LockInputBoundary lockInputBoundary = new LockInteractor(
                lockPresenter);

        return new LockController(lockInputBoundary);
    }
}
