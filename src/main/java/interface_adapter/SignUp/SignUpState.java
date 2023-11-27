package interface_adapter.SignUp;

import java.util.Date;

public class SignUpState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;
    private String repeatPassword = "";
    private String repeatPasswordError = null;
    private String email;
    private String emailError;
    private String phoneNumber;
    private String phoneNumberError;
    private String gender;
    private String insurance;
    private String insuranceError;

    private Date birthday;
    private String creditCardNumber;
    private String creditCardNumberError;
    private String contactName;
    private String contactNameError;
    private String contactPhoneNumber;
    private String contactPhoneNumberError;
    private String contactRelationship;
    private String contactRelationshipError;

    private int  ccv;
    private String ccvError;

    private String expirationDate;
    private String expirationDateError;

    private String nameOnCard;
    private String nameOnCardError;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumberError() {
        return phoneNumberError;
    }

    public void setPhoneNumberError(String phoneNumberError) {
        this.phoneNumberError = phoneNumberError;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getInsuranceError() {
        return insuranceError;
    }

    public void setInsuranceError(String insuranceError) {
        this.insuranceError = insuranceError;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumberError() {
        return creditCardNumberError;
    }

    public void setCreditCardNumberError(String creditCardNumberError) {
        this.creditCardNumberError = creditCardNumberError;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNameError() {
        return contactNameError;
    }

    public void setContactNameError(String contactNameError) {
        this.contactNameError = contactNameError;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactPhoneNumberError() {
        return contactPhoneNumberError;
    }

    public void setContactPhoneNumberError(String contactPhoneNumberError) {
        this.contactPhoneNumberError = contactPhoneNumberError;
    }

    public String getContactRelationship() {
        return contactRelationship;
    }

    public void setContactRelationship(String contactRelationship) {
        this.contactRelationship = contactRelationship;
    }

    public String getContactRelationshipError() {
        return contactRelationshipError;
    }

    public void setContactRelationshipError(String contactRelationshipError) {
        this.contactRelationshipError = contactRelationshipError;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public String getCcvError() {
        return ccvError;
    }

    public void setCcvError(String ccvError) {
        this.ccvError = ccvError;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDateError() {
        return expirationDateError;
    }

    public void setExpirationDateError(String expirationDateError) {
        this.expirationDateError = expirationDateError;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getNameOnCardError() {
        return nameOnCardError;
    }

    public void setNameOnCardError(String nameOnCardError) {
        this.nameOnCardError = nameOnCardError;
    }

    public SignUpState(SignUpState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
        repeatPassword = copy.repeatPassword;
        repeatPasswordError = copy.repeatPasswordError;
        email = copy.email;
        emailError = copy.emailError;
        phoneNumber = copy.phoneNumber;
        phoneNumberError = copy.phoneNumberError;
        insurance = copy.insurance;
        insuranceError = copy.insuranceError;
        this.gender = copy.gender;
        this.birthday = copy.birthday;
        this.creditCardNumber = copy.creditCardNumber;
        this.creditCardNumberError = copy.creditCardNumberError;
        this.contactName = copy.contactName;
        this.contactNameError = copy.contactNameError;
        this.contactPhoneNumber = copy.contactPhoneNumber;
        this.contactPhoneNumberError = copy.contactPhoneNumberError;
        this.contactRelationship = copy.contactRelationship;
        this.contactRelationshipError = copy.contactRelationshipError;

        this.ccv = copy.ccv;
        this.ccvError = copy.ccvError;

        this.expirationDate = copy.expirationDate;
        this.expirationDateError = copy.expirationDateError;

        this.nameOnCard = copy.nameOnCard;
        this.nameOnCardError = copy.nameOnCardError;


    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SignUpState() {
    }

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    @Override
    public String toString() {
        return "SignupState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repeatPassword='" + repeatPassword + '\'' +
                '}';
    }


}
