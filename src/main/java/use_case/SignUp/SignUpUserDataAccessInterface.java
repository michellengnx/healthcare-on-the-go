package use_case.SignUp;

import entities.Patient;

public interface SignUpUserDataAccessInterface {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void save(Patient patient);
}
