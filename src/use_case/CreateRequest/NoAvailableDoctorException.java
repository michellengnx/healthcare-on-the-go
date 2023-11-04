package use_case.CreateRequest;

public class NoAvailableDoctorException extends Exception {
    public NoAvailableDoctorException(String errorMessage) {
        super(errorMessage);
    }
}
