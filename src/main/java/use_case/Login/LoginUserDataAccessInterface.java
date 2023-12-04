package use_case.Login;


import entities.Patient;
import entities.User;

public interface LoginUserDataAccessInterface {
    boolean existsByUsername(String identifier);

    User get(String username);

    void save(Patient samplePatient);
}
