package interface_adapter.SignUp;

import interface_adapter.Login.LoginState;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.SignUp.SignUpOutputBoundary;
import use_case.SignUp.SignUpOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignUpPresenter implements SignUpOutputBoundary {

    private final SignUpViewModel signUpViewModel;
    private final LoginViewModel loginViewModel;

    private ViewManagerModel viewManagerModel;

    public SignUpPresenter(ViewManagerModel viewManagerModel,
                           SignUpViewModel signUpViewModel,
                           LoginViewModel loginViewModel
                        ) {
        this.viewManagerModel = viewManagerModel;
        this.signUpViewModel = signUpViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(SignUpOutputData response) {
        // On success, switch to the login view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SignUpState signUpState = signUpViewModel.getState();
        signUpState.setError(error);
        signUpViewModel.firePropertyChanged();
    }
}

