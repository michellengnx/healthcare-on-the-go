package interface_adapter.SignUp;

/**
 * Represents the state of the sign-up process.
 */
public class SignUpState {
    private String error = null;

    public SignUpState() {

    }


    /**
     * Retrieves the error message during the sign-up process.
     *
     * @return The error message.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message during the sign-up process.
     *
     * @param error The error message to set.
     */
    public void setError(String error) {
        this.error = error;
    }

    public Object getCreateRequestError() {
        return this.error;
    }
}
