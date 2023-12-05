package interface_adapter.SignUp;

import interface_adapter.Login.LoginState;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.SignUp.SignUpOutputBoundary;
import use_case.SignUp.SignUpOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Presenter handling the output for sign-up operations.
 */
public class SignUpPresenter implements SignUpOutputBoundary {

    private final SignUpViewModel signUpViewModel;
    private final LoginViewModel loginViewModel;

    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a SignUpPresenter with necessary view models and view manager.
     *
     * @param viewManagerModel The view manager model handling view updates.
     * @param signUpViewModel  The view model for the sign-up view.
     * @param loginViewModel   The view model for the login view.
     */
    public SignUpPresenter(ViewManagerModel viewManagerModel,
                           SignUpViewModel signUpViewModel,
                           LoginViewModel loginViewModel
                        ) {
        this.viewManagerModel = viewManagerModel;
        this.signUpViewModel = signUpViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Prepares the success view based on the sign-up response data.
     *
     * @param response The sign-up output data containing response information.
     */
    @Override
    public void prepareSuccessView(SignUpOutputData response) {
        // On success, switch to the login view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime() + "T00:00:00");
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view in case of a failed sign-up attempt.
     *
     * @param error The error message indicating the reason for failure.
     */
    @Override
    public void prepareFailView(String error) {
        SignUpState signUpState = signUpViewModel.getState();
        signUpState.setError(error);
        signUpViewModel.firePropertyChanged();
    }
}

