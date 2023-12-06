package interface_adapter.Login;

import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.Login.LoginOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginPresenterTest {

    @Test
    void prepareSuccessView_ShouldSwitchToLoggedInView() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HomeScreenViewModel loggedInViewModel = new HomeScreenViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);
        LoginOutputData successResponse = new LoginOutputData("testUser",false);

        // Act
        loginPresenter.prepareSuccessView(successResponse);

        // Assert
        assertEquals("testUser", loggedInViewModel.getState().getPatient());
        assertEquals(viewManagerModel.getActiveView(), loggedInViewModel.getViewName());
    }

    @Test
    void prepareFailView_ShouldSetErrorInLoginViewModel() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HomeScreenViewModel loggedInViewModel = new HomeScreenViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);

        // Act
        loginPresenter.prepareFailView("Invalid credentials");

        // Assert
    }
}
