package interface_adapter.LockView;

import interface_adapter.Login.LoginViewModel;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import use_case.LockView.LockOutputBoundary;
import view.LoginView;
import view.SignUpView;

/**
 * Presenter handling lock-related output interactions.
 */
public class LockPresenter implements LockOutputBoundary {
    ViewManagerModel viewManagerModel;
    SignUpViewModel signUpViewModel;
    LoginViewModel loginViewModel;

    /**
     * Constructs a LockPresenter with necessary view models and the view manager.
     *
     * @param viewManagerModel The view manager model handling view updates.
     * @param signUpViewModel  The view model for the sign-up view.
     * @param loginViewModel   The view model for the login view.
     */
    public LockPresenter(ViewManagerModel viewManagerModel,
                         SignUpViewModel signUpViewModel,
                         LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signUpViewModel = signUpViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Prepares the success view based on the provided view name.
     *
     * @param viewName The name of the view to be set as the active view.
     */
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
