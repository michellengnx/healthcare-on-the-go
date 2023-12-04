package use_case.EditProfile;

/**
 * Represents input data for editing a profile.
 */
public class EditInputData {
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

    /**
     * Constructs an EditInputData object with the provided details.
     *
     * @param username the username associated with the user's profile (not editable).
     * @param password the new password for the patient.
     * @param email the new email for the patient.
     * @param phoneNumber the new phone number for the patient.
     * @param insurance the new insurance information for the patient.
     * @param creditCardNumber the new credit card number for the patient.
     * @param cvv the new CVV for the patient's credit card.
     * @param expirationDate the new expiration date for the patient's credit card.
     * @param nameOnCard the new name on the credit card for the patient.
     * @param emergencyName the new emergency contact name for the patient.
     * @param emergencyNumber the new emergency contact number for the patient.
     * @param emergencyRelationship the new relationship with the emergency contact for the patient.
     */
    public EditInputData(String username, String password, String email, String phoneNumber, String insurance,
                         String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                         String emergencyName, String emergencyNumber, String emergencyRelationship) {
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
