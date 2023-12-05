package use_case.Login;

/**
 * Represents the output data after a login operation, containing user-related information.
 */
public class LoginOutputData {

    private final String username;
    private final boolean useCaseFailed;

    /**
     * Initializes a LoginOutputData instance with the provided username and use case status.
     *
     * @param username      The username associated with the login operation.
     * @param useCaseFailed Indicates whether the login use case failed or succeeded.
     */
    public LoginOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

}
