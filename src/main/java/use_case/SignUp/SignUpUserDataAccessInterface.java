package use_case.SignUp;

import entities.User;

public interface SignUpUserDataAccessInterface {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean passwordDoesNotMatch(String password, String repeatPassword);

    void save(User user);
}
