package use_case.Login;


import entities.User;

public interface LoginUserDataAccessInterface {
    boolean existsByUsername(String identifier);

    User get(String username);
}
