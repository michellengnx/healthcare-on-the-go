package use_case.SignUp;

/**
 * Represents the output data after a sign-up process.
 */
public class SignUpOutputData {

    private final String username;
    private String creationTime;

    private final boolean useCaseFailed;

    /**
     * Constructs the SignUpOutputData object.
     *
     * @param username      The username of the signed-up user.
     * @param creationTime  The timestamp indicating when the sign-up occurred.
     * @param useCaseFailed A boolean flag indicating if the use case failed.
     */
    public SignUpOutputData(String username, String creationTime, boolean useCaseFailed) {
        this.username = username;
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }
}
