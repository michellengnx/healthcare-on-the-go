package data_access.integration_test.EditProfile;

import org.junit.jupiter.api.Test;
import use_case.EditProfile.EditOutputData;

import static org.junit.jupiter.api.Assertions.*;

class EditProfileOutputDataTest {

    @Test
    void testEditOutputData() {
        // Sample data for testing
        String password = "newPassword";
        String email = "newEmail@example.com";
        String phoneNumber = "123-456-7890";
        String insurance = "New Insurance";
        String creditCardNumber = "1111222233334444";
        Integer cvv = 123;
        String expirationDate = "12/24";
        String nameOnCard = "New Cardholder";
        String emergencyName = "New Emergency Contact";
        String emergencyNumber = "987-654-3210";
        String emergencyRelationship = "Friend";

        // Creating an instance of EditOutputData
        EditOutputData editOutputData = new EditOutputData(
                password, email, phoneNumber, insurance, creditCardNumber, cvv,
                expirationDate, nameOnCard, emergencyName, emergencyNumber,
                emergencyRelationship, false);

        // Testing getters
        assertEquals(password, editOutputData.getPassword());
        assertEquals(email, editOutputData.getEmail());
        assertEquals(phoneNumber, editOutputData.getPhoneNumber());
        assertEquals(insurance, editOutputData.getInsurance());
        assertEquals(creditCardNumber, editOutputData.getCreditCardNumber());
        assertEquals(cvv, editOutputData.getCvv());
        assertEquals(expirationDate, editOutputData.getExpirationDate());
        assertEquals(nameOnCard, editOutputData.getNameOnCard());
        assertEquals(emergencyName, editOutputData.getEmergencyName());
        assertEquals(emergencyNumber, editOutputData.getEmergencyNumber());
        assertEquals(emergencyRelationship, editOutputData.getEmergencyRelationship());

        // Testing useCaseFailed flag
        assertFalse(editOutputData.isUseCaseFailed());
    }
}
