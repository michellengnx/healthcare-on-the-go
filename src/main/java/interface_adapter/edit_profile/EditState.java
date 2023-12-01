package interface_adapter.edit_profile;
// these fields will be populated by the homeviewmodel, which is populated by loginviewmodel, which is populated by signupviewmodel
public class EditState {
    private String username = "";
    private String password = "";
    private String passwordError = null;
    private String email = "";
    private String phoneNumber = "";
    private String insurance = "";
    private String creditCardNumber = "";
    private Integer cvv = 0;
    private String expirationDate = "";
    private String nameOnCard = "";
    private String emergencyName = "";
    private String emergencyNumber = "";
    private String emergencyRelationship = "";

    public EditState(EditState copy) {
        username = copy.username;
        password = copy.password;
        passwordError = copy.passwordError;
        email = copy.email;
        phoneNumber = copy.phoneNumber;
        insurance = copy.insurance;
        creditCardNumber = copy.creditCardNumber;
        cvv = copy.cvv;
        expirationDate = copy.expirationDate;
        nameOnCard = copy.nameOnCard;
        emergencyName = copy.emergencyName;
        emergencyNumber = copy.emergencyNumber;
        emergencyRelationship = copy.emergencyRelationship;
    }

    public EditState() {}

    public String getUsername() {
        return username;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getInsurance() {
        return insurance;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }


    public String getEmergencyRelationship() {
        return emergencyRelationship;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setInsurance(String newInsurance) {
        this.insurance = insurance;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public void setEmergencyRelationship(String emergencyRelationship) {
        this.emergencyRelationship = emergencyRelationship;
    }
}
