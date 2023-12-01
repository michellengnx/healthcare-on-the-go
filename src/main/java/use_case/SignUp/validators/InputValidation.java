package use_case.SignUp.validators;

import java.util.Objects;

public class InputValidation {

    public static boolean passwordMatches(String password, String repeatPassword) {
        return Objects.equals(password, repeatPassword);
    }

    // TODO: Expand implementation
    public static boolean isPasswordValid(String password) {
        // Example: Password must be at least 8 characters long
        return password.length() >= 8;
    }

    // TODO: Expand implementation
    public static boolean isValidEmail(String email) {
        // Example: Simple email format check using regular expression
        String emailRegex = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$";
        return email.matches(emailRegex);
    }
}

