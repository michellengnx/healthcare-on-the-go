package use_case.Login;


import entities.User;

/**
 * Represents an interface for accessing user data related to the login use case.
 */
public interface LoginUserDataAccessInterface {
    boolean existsByUsername(String identifier);

    User get(String username);
}
