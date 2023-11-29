package interface_adapter.edit_profile;
// these fields will be populated by the homeviewmodel, which is populated by loginviewmodel, which is populated by signupviewmodel
public class EditState {
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
    private String creditCardNumber = "";
    private String creditCardNumberError = null;
    private Integer cvv = 0;
    private String cvvError = null;
    private String expirationDate = "";
    private String expirationDateError = null;
    private String nameOnCard = "";
    private String nameOnCardError = null;
    private String emergencyName = "";
    private String emergencyNameError = null;
    private String emergencyNumber = "";
    private String emergencyNumberError = null;
    private String emergencyRelationship = "";
    private String emergencyRelationshipError = null;

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
        creditCardNumber = copy.creditCardNumber;
        creditCardNumberError = copy.creditCardNumberError;
        cvv = copy.cvv;
        cvvError = copy.cvvError;
        expirationDate = copy.expirationDate;
        expirationDateError = copy.expirationDateError;
        nameOnCard = copy.nameOnCard;
        nameOnCardError = copy.nameOnCardError;
        emergencyName = copy.emergencyName;
        emergencyNameError = copy.emergencyNameError;
        emergencyNumber = copy.emergencyNumber;
        emergencyNameError = copy.emergencyNumberError;
        emergencyRelationship = copy.emergencyRelationship;
        emergencyRelationship = copy.emergencyRelationshipError;
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

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCreditCardNumberError() {
        return creditCardNumberError;
    }

    public Integer getCvv() {
        return cvv;
    }

    public String getCvvError() {
        return cvvError;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getExpirationDateError() {
        return expirationDateError;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getNameOnCardError() {
        return nameOnCardError;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public String getEmergencyNameError() {
        return emergencyNameError;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public String getEmergencyNumberError() {
        return emergencyNumberError;
    }

    public String getEmergencyRelationship() {
        return emergencyRelationship;
    }

    public String getEmergencyRelationshipError() {
        return emergencyRelationshipError;
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

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCreditCardNumberError(String creditCardNumberError) {
        this.creditCardNumberError = creditCardNumberError;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public void setCvvError(String cvvError) {
        this.cvvError = cvvError;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setExpirationDateError(String expirationDateError) {
        this.expirationDateError = expirationDateError;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setNameOnCardError(String nameOnCardError) {
        this.nameOnCardError = nameOnCardError;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public void setEmergencyNameError(String emergencyNameError) {
        this.emergencyNameError = emergencyNameError;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public void setEmergencyNumberError(String emergencyNumberError) {
        this.emergencyNumberError = emergencyNumberError;
    }

    public void setEmergencyRelationship(String emergencyRelationship) {
        this.emergencyRelationship = emergencyRelationship;
    }

    public void setEmergencyRelationshipError(String emergencyRelationshipError) {
        this.emergencyRelationshipError = emergencyRelationshipError;
    }
}
