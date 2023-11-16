package use_case.edit_profile;

import entities.Patient;
import entities.User;

public interface EditUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Patient patient);

    User get(String username);

    String editUsername(String username, String password, String newUsername);

    String editPassword(String username, String password, String newPassword);

    String editInsurance(String username, String password, String newInsurance);

    String editEmail(String username, String password, String newEmail);

    String editPhoneNumber(String username, String password, String newPhoneNumber);
}
