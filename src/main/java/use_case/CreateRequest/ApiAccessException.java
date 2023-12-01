package use_case.CreateRequest;

/**
 * Exception to be thrown whenever there is an issue accessing the API.
 */
public class ApiAccessException extends Exception {

    /**
     * Create a ApiAccessException.
     */
    public ApiAccessException() {
        super("There was a problem accessing the routing API");
    }
}