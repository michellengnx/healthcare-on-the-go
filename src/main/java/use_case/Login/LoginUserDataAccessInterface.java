package use_case.Login;


import entities.User;

public interface LoginUserDataAccessInterface {
    boolean existByUsername(String identifier);

    User get(String username);
}
