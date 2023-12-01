package entities.factories.service_request;

public class DataUnavailableException extends Exception {
    public DataUnavailableException() {
        super("Data is unavailable");
    }
}
