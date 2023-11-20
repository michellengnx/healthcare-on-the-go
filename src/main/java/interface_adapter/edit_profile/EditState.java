package interface_adapter.edit_profile;

public class EditState {
    private String username = "";
    private String usernameError = null;
    private String newUsername = "";
    private String newUsernameError = null;
    private String newPassword = "";
    private String newPasswordError = null;
    private String newEmail = "";
    private String newEmailError = null;
    private String newPhoneNumber = "";
    private String newPhoneNumberError = null;
    private String newInsurance = "";
    private String newInsuranceError = null;

    public EditState(EditState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        newUsername = copy.newUsername;
        newUsernameError = copy.newUsernameError;
        newPassword = copy.newPassword;
        newPasswordError = copy.newPasswordError;
        newEmail = copy.newEmail;
        newEmailError = copy.newEmailError;
        newPhoneNumber = copy.newPhoneNumber;
        newPhoneNumberError = copy.newPhoneNumberError;
        newInsurance = copy.newInsurance;
        newInsuranceError = copy.newInsuranceError;
    }

    public EditState() {}

    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getNewUsername() {
        return newUsername;
    }
    public String getNewUsernameError() {
        return newUsernameError;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewPasswordError() {
        return newPasswordError;
    }
    public String getNewEmail() {
        return newEmail;
    }

    public String getNewEmailError() {
        return newEmailError;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }

    public String getNewPhoneNumberError() {
        return newPhoneNumberError;
    }

    public String getNewInsurance() {
        return newInsurance;
    }

    public String getNewInsuranceError() {
        return newInsuranceError;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public void setNewUsernameError(String newUsernameError) {
        this.newUsernameError = newUsernameError;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setNewPasswordError(String newPasswordError) {
        this.newPasswordError = newPasswordError;
    }
    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public void setNewEmailError(String newEmailError) {
        this.newEmailError = newEmailError;
    }

    public void setNewPhoneNumber(String newPhoneNumber) {
        this.newPhoneNumber = newPhoneNumber;
    }

    public void setNewPhoneNumberError(String newPhoneNumberError) {
        this.newPhoneNumberError = newPhoneNumberError;
    }

    public void setNewInsurance(String newInsurance) {
        this.newInsurance = newInsurance;
    }

    public void setNewInsuranceError(String newInsuranceError) {
        this.newInsuranceError = newInsuranceError;
    }
}
