package org.example.src.use_case.edit_profile;

public class EditInputData {

    final private String newUsername;
    final private String newPassword;
    final private String newEmail;
    final private String newPhoneNumber;
    final private String newInsurance;

    public EditInputData(String newUsername, String newPassword, String newEmail,
                         String newPhoneNumber, String newInsurance) {
        this.newUsername = newUsername;
        this.newPassword = newPassword;
        this.newEmail = newEmail;
        this.newPhoneNumber = newPhoneNumber;
        this.newInsurance = newInsurance;
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
