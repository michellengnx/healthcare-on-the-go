package interface_adapter.SignUp;

import interface_adapter.SignUp.SignUpState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SignUpStateTest {

    private SignUpState originalState;

    @BeforeEach
    public void setUp() {
        // Set up common state for tests
        originalState = new SignUpState();
        originalState.setError("Registration failed");
    }

    @Test
    public void testCopyConstructor() {
        // Use the copy constructor
        SignUpState copiedState = new SignUpState(originalState);

        // Check if the values are copied correctly
        assertEquals(originalState.getError(), copiedState.getError());
    }

    @Test
    public void testDefaultConstructor() {
        // Create a SignUpState object using the default constructor
        SignUpState defaultState = new SignUpState();

        // Check if the values are initialized correctly (null error)
        assertNull(defaultState.getError());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a SignUpState object
        SignUpState signUpState = new SignUpState();

        // Set value using setter
        signUpState.setError("Email already exists");

        // Check if value is retrieved correctly using getter
        assertEquals("Email already exists", signUpState.getError());
    }
}
