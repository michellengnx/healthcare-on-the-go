package use_case.edit_profile;

public class EditOutputData {
    private final String password;
    private final String email;
    private final String phoneNumber;
    private final String insurance;
    private final String creditCardNumber;
    private final Integer cvv;
    private final String expirationDate;
    private final String nameOnCard;
    private final String emergencyName;
    private final String emergencyNumber;
    private final String emergencyRelationship;

    private boolean useCaseFailed;

    public EditOutputData(String password, String email, String phoneNumber, String insurance,
                          String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                          String emergencyName, String emergencyNumber, String emergencyRelationship,
                          boolean useCaseFailed) {
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.insurance = insurance;
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
        this.emergencyName = emergencyName;
        this.emergencyNumber = emergencyNumber;
        this.emergencyRelationship = emergencyRelationship;
        this.useCaseFailed = useCaseFailed;
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
