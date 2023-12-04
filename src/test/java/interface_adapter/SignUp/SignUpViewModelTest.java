package interface_adapter.SignUp;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SignUpViewModelTest {

    @Test
    void constructorAndGetState() {
        // Arrange
        SignUpViewModel signUpViewModel = new SignUpViewModel();
        SignUpState expectedState = new SignUpState();

        // Act
        SignUpState actualState = signUpViewModel.getState();

        // Assert
        assertEquals(expectedState.getError(), actualState.getError());
    }

    @Test
    void setStateAndGetState() {
        // Arrange
        SignUpViewModel signUpViewModel = new SignUpViewModel();
        SignUpState newState = new SignUpState();

        // Act
        signUpViewModel.setState(newState);
        SignUpState actualState = signUpViewModel.getState();

        // Assert
        assertEquals(newState, actualState);
    }

    @Test
    void addPropertyChangeListener_FirePropertyChanged() {
        // Arrange
        SignUpViewModel signUpViewModel = new SignUpViewModel();
        TestPropertyChangeListener listener = new TestPropertyChangeListener();
        signUpViewModel.addPropertyChangeListener(listener);

        // Act
        signUpViewModel.firePropertyChanged();

        // Assert
        assertTrue(listener.propertyChangeInvoked);
    }

    // Helper class for testing property change events
    private static class TestPropertyChangeListener implements PropertyChangeListener {
        private boolean propertyChangeInvoked = false;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            propertyChangeInvoked = true;
        }
    }
}

