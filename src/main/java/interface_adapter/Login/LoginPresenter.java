package interface_adapter.Login;


import interface_adapter.HomeScreen.HomeScreenState;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.Loggedin.LoggedinState;
import interface_adapter.Loggedin.LoggedinViewModel;
import interface_adapter.ViewManagerModel;
import use_case.Login.LoginOutputBoundary;
import use_case.Login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final HomeScreenViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          HomeScreenViewModel loggedInViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        HomeScreenState loggedinState = loggedInViewModel.getState();
        loggedinState.setPatient(response.getUsername());
        this.loggedInViewModel.setState(loggedinState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
