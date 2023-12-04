package interface_adapter.Login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginStateTest {

    private LoginState originalState;

    @BeforeEach
    public void setUp() {
        // Set up common state for tests
        originalState = new LoginState();
        originalState.setUsername("john_doe");
        originalState.setPassword("password123");
        originalState.setError("Invalid credentials");
    }

    @Test
    public void testCopyConstructor() {
        // Use the copy constructor
        LoginState copiedState = new LoginState(originalState);

        // Check if the values are copied correctly
        assertEquals(originalState.getUsername(), copiedState.getUsername());
        assertEquals(originalState.getPassword(), copiedState.getPassword());
    }

    @Test
    public void testDefaultConstructor() {
        // Create a LoginState object using the default constructor
        LoginState defaultState = new LoginState();

        // Check if the values are initialized correctly (empty strings and null error)
        assertEquals("", defaultState.getUsername());
        assertEquals("", defaultState.getPassword());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a LoginState object
        LoginState loginState = new LoginState();

        // Set values using setters
        loginState.setUsername("jane_doe");
        loginState.setPassword("secure_password");
        loginState.setError("Authentication failed");

        // Check if values are retrieved correctly using getters
        assertEquals("jane_doe", loginState.getUsername());
        assertEquals("secure_password", loginState.getPassword());
    }
}
