package use_case.SignUp.validators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidationTest {

    @Test
    void testPasswordMatches() {
        assertTrue(InputValidation.passwordMatches("password", "password"));
        assertFalse(InputValidation.passwordMatches("password", "differentpassword"));
    }

    @Test
    void testIsPasswordValid() {
        assertTrue(InputValidation.isPasswordValid("password123"));
        assertFalse(InputValidation.isPasswordValid("short"));
    }

    @Test
    void testIsValidEmail() {
        assertTrue(InputValidation.isValidEmail("test@example.com"));
        assertFalse(InputValidation.isValidEmail("invalid-email"));
    }
}
