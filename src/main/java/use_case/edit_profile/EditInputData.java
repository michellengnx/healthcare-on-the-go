package use_case.edit_profile;

public class EditInputData {
    final private String oldUsername;
    final private String username;
    final private String password;
    final private String email;
    final private String phoneNumber;
    final private String insurance;
    final private String creditCardNumber;
    final private Integer cvv;
    final private String expirationDate;
    final private String nameOnCard;
    final private String emergencyName;
    final private String emergencyNumber;
    final private String emergencyRelationship;

    public EditInputData(String oldUsername, String username, String password, String email, String phoneNumber, String insurance,
                         String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                         String emergencyName, String emergencyNumber, String emergencyRelationship) {
        this.oldUsername = oldUsername;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.insurance = insurance;
        this.creditCardNumber =  creditCardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
        this.emergencyName = emergencyName;
        this.emergencyNumber = emergencyNumber;
        this.emergencyRelationship = emergencyRelationship;
    }

    public String getOldUsername() {return oldUsername;}
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
}
