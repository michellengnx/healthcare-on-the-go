package org.example.src.use_case.edit_profile;

public class EditInputData {

    final private String username;
    final private String newUsername;
    final private String newPassword;
    final private String newEmail;
    final private String newPhoneNumber;
    final private String newInsurance;

    // if the user doesn't want to change some parameter,
    // the default value will be the current string stored in said parameter.
    public EditInputData(String username, String newUsername, String newPassword,
                         String newEmail, String newPhoneNumber, String newInsurance) {
        this.username = username;
        this.newUsername = newUsername;
        this.newPassword = newPassword;
        this.newEmail = newEmail;
        this.newPhoneNumber = newPhoneNumber;
        this.newInsurance = newInsurance;
    }

    public String getUsername() {
        return username;
    }
    public String getNewUsername() {
        return newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }

    public String getNewInsurance() {
        return newInsurance;
    }
}
