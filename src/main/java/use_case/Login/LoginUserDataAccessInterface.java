package use_case.Login;


import entities.Patient;
import entities.User;

/**
 * Represents an interface for accessing user data related to the login use case.
 */
public interface LoginUserDataAccessInterface {
    boolean existsByUsername(String identifier);

    User get(String username);

    void save(Patient samplePatient);
}
