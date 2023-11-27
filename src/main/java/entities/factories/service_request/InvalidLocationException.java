package entities.factories.service_request;

/**
 * Exception to be thrown whenever an argument to a function is an invalid location.
 */
public class InvalidLocationException extends Exception {
    /**
     * Create a InvalidLocationException with a given message.
     *
     * @param errorMessage The message to be displayed alongside the error.
     */
    public InvalidLocationException(String errorMessage) {
        super(errorMessage);
    }
}
