package use_case.ResolveRequest;

/**
 * Exception to be thrown when a request associated with a patient couldn't be found.
 */
public class NoRequestFoundException extends Exception {
    public NoRequestFoundException() {
        super("The couldn't find the request corresponding to the given patient");
    }
}
