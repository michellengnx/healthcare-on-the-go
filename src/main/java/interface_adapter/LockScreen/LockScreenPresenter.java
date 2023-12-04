package interface_adapter.LockScreen;

import interface_adapter.Login.LoginViewModel;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import use_case.LockScreen.LockScreenOutputBoundary;

public class LockScreenPresenter implements LockScreenOutputBoundary {
    ViewManagerModel viewManagerModel;
    SignUpViewModel signUpViewModel;
    LoginViewModel loginViewModel;

    public LockScreenPresenter(ViewManagerModel viewManagerModel,
                               SignUpViewModel signUpViewModel,
                               LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signUpViewModel = signUpViewModel;
        this.loginViewModel = loginViewModel;
    }

    public void prepareSuccessView(String viewName) {
        switch (viewName) {
            case "log in":
                this.viewManagerModel.setActiveView(loginViewModel.getViewName());
                break;
            case "sign up":
                this.viewManagerModel.setActiveView(signUpViewModel.getViewName());
                break;
        }
        this.viewManagerModel.firePropertyChanged();
    }
}
