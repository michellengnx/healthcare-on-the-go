package interface_adapter.edit_profile;

public class EditState {

    // do I need to make the parameters optional in FilePatientDataAccessObject if there is a respective error for null?
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;
    private String email = "";
    private String emailError = null;
    private String phoneNumber = "";
    private String phoneNumberError = null;
    private String insurance = "";
    private String insuranceError = null;

    public EditState(EditState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
        email = copy.email;
        emailError = copy.emailError;
        phoneNumber = copy.phoneNumber;
        phoneNumberError = copy.phoneNumberError;
        insurance = copy.insurance;
        insuranceError = copy.insuranceError;
    }

    public EditState() {}

    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailError() {
        return emailError;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneNumberError() {
        return phoneNumberError;
    }

    public String getInsurance() {
        return insurance;
    }

    public String getInsuranceError() {
        return insuranceError;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setPassword(String newPassword) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumberError(String newPhoneNumberError) {
        this.phoneNumberError = phoneNumberError;
    }

    public void setInsurance(String newInsurance) {
        this.insurance = insurance;
    }

    public void setInsuranceError(String newInsuranceError) {
        this.insuranceError = insuranceError;
    }
}
