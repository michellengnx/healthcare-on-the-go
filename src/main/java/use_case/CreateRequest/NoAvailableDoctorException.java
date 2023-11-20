package use_case.CreateRequest;

/**
 * Exception to be thrown whenever there are no doctors available to carry out a request.
 */
public class NoAvailableDoctorException extends Exception {

    /**
     * Create a NoAvailableDoctorException with a given message.
     *
     * @param errorMessage The message to be displayed alongside the error.
     */
    public NoAvailableDoctorException(String errorMessage) {
        super(errorMessage);
    }
}
