package use_case.SignUp;

import java.util.Date;

public class SignUpInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;
    final private String email;
    final private String phoneNumber;
    final private String gender;
    final private String insurance;

    final private Date birthday;
    final private String creditCardNumber;
    private final String contactName;
    private final String contactPhoneNumber;
    private final String contactRelationship;

    final private int  ccv;
    final private String expirationDate;
    final private String nameOnCard;

    //    private String creditCardNumber;
//    private int ccv;
//    //   TODO: expirationDate should not be string
//    private String expirationDate;
//    private String nameOnCard;
    public SignUpInputData(String username,
                           String password,
                           String repeatPassword,
                           String email,
                           String phoneNumber,
                           String gender,
                           String insurance,
                           Date birthday,
                           String creditCardNumber,
                           int ccv,
                           String expirationDate,
                           String nameOnCard,
                           String contactName,
                           String contactPhoneNumber,
                           String contactRelationship
                           ) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.insurance = insurance;
        this.birthday = birthday;
        this.ccv = ccv;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
        this.creditCardNumber = creditCardNumber;
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactRelationship = contactRelationship;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getInsurance() {
        return insurance;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getCcv() {
        return ccv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public String getContactRelationship() {
        return contactRelationship;
    }
}
