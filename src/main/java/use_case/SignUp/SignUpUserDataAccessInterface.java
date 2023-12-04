package use_case.SignUp;

import entities.Patient;

/**
 * Interface defining the methods to access user sign-up data.
 */
public interface SignUpUserDataAccessInterface {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void save(Patient patient);
}
