package app;

import interface_adapter.LockScreen.LockController;
import interface_adapter.LockScreen.LockScreenPresenter;
import interface_adapter.LockScreen.LockScreenModel;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import use_case.LockScreen.LockScreenInputBoundary;
import use_case.LockScreen.LockScreenInteractor;
import use_case.LockScreen.LockScreenOutputBoundary;
import view.LockScreenView;

import java.io.IOException;

public class LockUseCaseFactory {
    public static LockScreenView create(ViewManagerModel viewManagerModel,
                                        LockScreenModel lockScreenModel,
                                        SignUpViewModel signUpViewModel,
                                        LoginViewModel loginViewModel) throws IOException {
        LockController lockController = createLockUseCase(
                viewManagerModel,
                signUpViewModel,
                loginViewModel);
        return new LockScreenView(lockScreenModel, lockController);

    }

    private static LockController createLockUseCase(ViewManagerModel viewManagerModel,
                                                          SignUpViewModel signUpViewModel,
                                                          LoginViewModel loginViewModel) {

        LockScreenOutputBoundary lockPresenter = new LockScreenPresenter(
                viewManagerModel,
                signUpViewModel,
                loginViewModel);

        LockScreenInputBoundary lockScreenInputBoundary = new LockScreenInteractor(
                lockPresenter);

        return new LockController(lockScreenInputBoundary);
    }
}
