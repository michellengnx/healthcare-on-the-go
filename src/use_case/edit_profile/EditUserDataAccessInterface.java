package org.example.src.use_case.edit_profile;

import org.example.src.entities.User;

public interface EditUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);

    String editProfile(String username, String newUsername, String newPassword, String newEmail,
                       String newPhoneNumber, String newInsurance);
}
