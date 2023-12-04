package use_case.SignUp;

/**
 * Interface defining the boundary for the Sign-Up use case input.
 * It provides a contract for executing sign-up operations.
 */
public interface SignUpInputBoundary {
    void execute(SignUpInputData signupInputData);
}
