package use_case.ResolveRequest;

/**
 * Exception to be thrown when the request associated with a patient can't be found
 */
public class NoRequestFoundException extends Exception {
    public NoRequestFoundException() {
        super("The couldn't find the request corresponding to the given patient");
    }
}
