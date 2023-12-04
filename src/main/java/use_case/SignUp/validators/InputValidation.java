package use_case.SignUp.validators;

import java.util.Objects;

/**
 * Utility class containing methods for input validation used in the sign-up process.
 */
public class InputValidation {

    /**
     * Checks if the provided password matches the repeated password.
     *
     * @param password        The password to be checked.
     * @param repeatPassword  The repeated password for validation.
     * @return True if the passwords match, false otherwise.
     */
    public static boolean passwordMatches(String password, String repeatPassword) {
        return Objects.equals(password, repeatPassword);
    }

    /**
     * Validates the password against specific criteria (e.g., minimum length).
     *
     * @param password The password to be validated.
     * @return True if the password meets the defined criteria, false otherwise.
     */
    public static boolean isPasswordValid(String password) {
        // Example: Password must be at least 8 characters long
        return password.length() >= 8;
    }

    /**
     * Validates an email address using a simple regular expression check.
     *
     * @param email The email address to be validated.
     * @return True if the email address matches the defined pattern, false otherwise.
     */
    public static boolean isValidEmail(String email) {
        // Example: Simple email format check using regular expression
        String emailRegex = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$";
        return email.matches(emailRegex);
    }
}

