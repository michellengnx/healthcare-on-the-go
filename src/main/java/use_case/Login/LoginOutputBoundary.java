package use_case.Login;

/**
 * Interface defining the output boundaries for the login use case.
 * It specifies methods to handle success and failure scenarios after login attempts.
 */
public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user);

    void prepareFailView(String error);
}