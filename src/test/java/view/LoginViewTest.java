package view;

import interface_adapter.Login.LoginController;
import interface_adapter.Login.LoginState;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.ReturnToLock.ReturnToLockController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LoginViewTest {

    private LoginViewModel loginViewModel;
    private LoginController loginController;
    private ReturnToLockController returnToLockController;
    private LoginView loginView;

    @BeforeEach
    void setUp() {
        loginViewModel = new LoginViewModel();
        loginController = mock(LoginController.class);
        returnToLockController = mock(ReturnToLockController.class);
        loginView = new LoginView(loginViewModel, loginController, returnToLockController);
    }

    @Test
    void actionPerformed_loginButtonClicked_executeLoginController() {
        loginViewModel.setState(new LoginState());
        loginView.logIn.doClick();
        verify(loginController, times(1)).execute(anyString(), anyString());
    }

    @Test
    void actionPerformed_cancelButtonClicked_executeReturnToLockController() {
        loginView.cancel.doClick();
        verify(returnToLockController, times(1)).execute();
    }

}
