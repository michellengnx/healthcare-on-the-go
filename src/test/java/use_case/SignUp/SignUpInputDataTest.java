package use_case.SignUp;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SignUpInputDataTest {

    @Test
    void testSignUpInputDataCreation() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";
        String repeatPassword = "testPassword";
        String email = "test@example.com";
        String phoneNumber = "1234567890";
        String gender = "Male";
        String insurance = "InsuranceXYZ";
        Date birthday = new Date();
        String creditCardNumber = "1234567890123456";
        int ccv = 123;
        String expirationDate = "12/25";
        String nameOnCard = "John Doe";
        String contactName = "Jane Doe";
        String contactPhoneNumber = "9876543210";
        String contactRelationship = "Friend";

        // Act
        SignUpInputData signUpInputData = new SignUpInputData(
                username, password, repeatPassword, email, phoneNumber, gender,
                insurance, birthday, creditCardNumber, ccv, expirationDate,
                nameOnCard, contactName, contactPhoneNumber, contactRelationship
        );

        // Assert
        assertNotNull(signUpInputData, "SignUpInputData should not be null");
        assertEquals(username, signUpInputData.getUsername(), "Username should match");
        assertEquals(password, signUpInputData.getPassword(), "Password should match");
        assertEquals(repeatPassword, signUpInputData.getRepeatPassword(), "RepeatPassword should match");
        assertEquals(email, signUpInputData.getEmail(), "Email should match");
        assertEquals(phoneNumber, signUpInputData.getPhoneNumber(), "PhoneNumber should match");
        assertEquals(gender, signUpInputData.getGender(), "Gender should match");
        assertEquals(insurance, signUpInputData.getInsurance(), "Insurance should match");
        assertEquals(birthday, signUpInputData.getBirthday(), "Birthday should match");
        assertEquals(creditCardNumber, signUpInputData.getCreditCardNumber(), "CreditCardNumber should match");
        assertEquals(ccv, signUpInputData.getCcv(), "CCV should match");
        assertEquals(expirationDate, signUpInputData.getExpirationDate(), "ExpirationDate should match");
        assertEquals(nameOnCard, signUpInputData.getNameOnCard(), "NameOnCard should match");
        assertEquals(contactName, signUpInputData.getContactName(), "ContactName should match");
        assertEquals(contactPhoneNumber, signUpInputData.getContactPhoneNumber(), "ContactPhoneNumber should match");
        assertEquals(contactRelationship, signUpInputData.getContactRelationship(), "ContactRelationship should match");
    }
}

