package use_case.Login;

/**
 * Defines the input boundary contract for the login operation.
 * Implementations handle the execution of login using provided login input data.
 */
public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData);
}
