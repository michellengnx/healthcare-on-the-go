package use_case.edit_profile;

public class EditInputData {
    // should optional be here too?
    final private String username;
    final private String newUsername;
    final private String newPassword;
    final private String newInsurance;
    final private String newEmail;
    final private String newPhoneNumber;

    public EditInputData(String username, String newUsername, String newPassword,
                         String newInsurance, String newEmail, String newPhoneNumber) {
        this.username = username;
        this.newUsername = newUsername;
        this.newPassword = newPassword;
        this.newInsurance = newInsurance;
        this.newEmail = newEmail;
        this.newPhoneNumber = newPhoneNumber;
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

    public String getNewInsurance() {
        return newInsurance;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }
}
