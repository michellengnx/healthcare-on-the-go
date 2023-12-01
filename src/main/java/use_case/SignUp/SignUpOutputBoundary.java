package use_case.SignUp;

public interface SignUpOutputBoundary {
    void prepareSuccessView(SignUpOutputData user);

    void prepareFailView(String error);
}