package interface_adapter.SignUp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SignUpStateTest {

    private SignUpState originalState;

    @BeforeEach
    public void setUp() {
        // Set up common state for tests
        originalState = new SignUpState();
        originalState.setError("Registration failed");
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
