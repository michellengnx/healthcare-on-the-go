package interface_adapter.edited_profile;

public class EditedState {
    private String password = "";
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

    public EditedState(EditedState copy) {
        password = copy.password;
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

    public EditedState() {}

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setInsurance(String insurance) {
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
