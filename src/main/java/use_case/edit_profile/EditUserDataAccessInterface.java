package use_case.edit_profile;

import entities.Patient;
import entities.User;

public interface EditUserDataAccessInterface {
    void save(Patient patient);

    User get(String username);

    Integer editProfile(String username, String newUsername, String newPassword,
                       String newInsurance, String newEmail, String newPhoneNumber);
}
