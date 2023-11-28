package use_case.edit_profile;

public class EditInputData {
    final private String username;
    final private String password;
    final private String email;
    final private String phoneNumber;
    final private String insurance;
    final private String emergencyName;
    final private String emergencyNumber;
    final private String emergencyRelationship;
    final private String creditCardNumber;
    final private Integer cvv;
    final private String expirationDate;
    final private String nameOnCard;

    public EditInputData(String username, String password, String email, String phoneNumber, String insurance,
                         String emergencyName, String emergencyNumber, String emergencyRelationship,
                         String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.insurance = insurance;
        this.emergencyName = emergencyName;
        this.emergencyNumber = emergencyNumber;
        this.emergencyRelationship = emergencyRelationship;
        this.creditCardNumber =  creditCardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
    }

    public String getUsername() {
        return username;
    }

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

    public String getEmergencyName() {
        return emergencyName;
    }

    public String getEmergencyNumber() {
        return emergencyNumber
    }

    public String getEmergencyRelationship() {
        return emergencyRelationship;
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
}
