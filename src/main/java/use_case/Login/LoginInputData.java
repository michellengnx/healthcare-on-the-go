package use_case.Login;

/**
 * Represents the login input data containing the username and password.
 */
public class LoginInputData {

    final private String username;
    final private String password;

    /**
     * Initializes login input data with the provided username and password.
     *
     * @param username The username used for login authentication.
     * @param password The password associated with the username.
     */
    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

}
