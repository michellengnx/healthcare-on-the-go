package use_case.SignUp;

/**
 * Defines the boundary for presenting sign-up use case output.
 */
public interface SignUpOutputBoundary {
    void prepareSuccessView(SignUpOutputData user);

    void prepareFailView(String error);
}