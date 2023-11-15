package use_case.ResolveRequest;

public class NoRequestFoundException extends Exception {
    public NoRequestFoundException() {
        super("The couldn't find the request corresponding to the given patient");
    }
}
