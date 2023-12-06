package interface_adapter.EditProfile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditStateTest {

    private EditState editState;

    @BeforeEach
    void setUp() {
        editState = new EditState();
    }

    @Test
    void getUsername() {
        editState.setUsername("john_doe");
        assertEquals("john_doe", editState.getUsername());
    }

    @Test
    void getPassword() {
        editState.setPassword("new_password");
        assertEquals("new_password", editState.getPassword());
    }

    @Test
    void getPasswordError() {
        editState.setPasswordError("Invalid password");
        assertEquals("Invalid password", editState.getPasswordError());
    }

    @Test
    void getEmail() {
        editState.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", editState.getEmail());
    }

    @Test
    void getPhoneNumber() {
        editState.setPhoneNumber("+1234567890");
        assertEquals("+1234567890", editState.getPhoneNumber());
    }

    @Test
    void getInsurance() {
        editState.setInsurance("Health Insurance");
        assertEquals("Health Insurance", editState.getInsurance());
    }

    @Test
    void getCreditCardNumber() {
        editState.setCreditCardNumber("1234567890123456");
        assertEquals("1234567890123456", editState.getCreditCardNumber());
    }

    @Test
    void getCvv() {
        editState.setCvv(123);
        assertEquals(123, editState.getCvv());
    }

    @Test
    void getExpirationDate() {
        editState.setExpirationDate("12/24");
        assertEquals("12/24", editState.getExpirationDate());
    }

    @Test
    void getNameOnCard() {
        editState.setNameOnCard("John Doe");
        assertEquals("John Doe", editState.getNameOnCard());
    }

    @Test
    void getEmergencyName() {
        editState.setEmergencyName("Emergency Contact");
        assertEquals("Emergency Contact", editState.getEmergencyName());
    }

    @Test
    void getEmergencyNumber() {
        editState.setEmergencyNumber("+123456789");
        assertEquals("+123456789", editState.getEmergencyNumber());
    }

    @Test
    void getEmergencyRelationship() {
        editState.setEmergencyRelationship("Family");
        assertEquals("Family", editState.getEmergencyRelationship());
    }

    @Test
    void setUsername() {
        editState.setUsername("jane_doe");
        assertEquals("jane_doe", editState.getUsername());
    }

    @Test
    void setPassword() {
        editState.setPassword("new_password_123");
        assertEquals("new_password_123", editState.getPassword());
    }

    @Test
    void setPasswordError() {
        editState.setPasswordError("Password must contain at least 8 characters");
        assertEquals("Password must contain at least 8 characters", editState.getPasswordError());
    }

    @Test
    void setEmail() {
        editState.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", editState.getEmail());
    }

    @Test
    void setPhoneNumber() {
        editState.setPhoneNumber("+9876543210");
        assertEquals("+9876543210", editState.getPhoneNumber());
    }

    @Test
    void setInsurance() {
        editState.setInsurance("Life Insurance");
        assertEquals("Life Insurance", editState.getInsurance());
    }

    @Test
    void setCreditCardNumber() {
        editState.setCreditCardNumber("9876543210987654");
        assertEquals("9876543210987654", editState.getCreditCardNumber());
    }

    @Test
    void setCvv() {
        editState.setCvv(456);
        assertEquals(456, editState.getCvv());
    }

    @Test
    void setExpirationDate() {
        editState.setExpirationDate("01/23");
        assertEquals("01/23", editState.getExpirationDate());
    }

    @Test
    void setNameOnCard() {
        editState.setNameOnCard("Jane Doe");
        assertEquals("Jane Doe", editState.getNameOnCard());
    }

    @Test
    void setEmergencyName() {
        editState.setEmergencyName("Emergency Contact 2");
        assertEquals("Emergency Contact 2", editState.getEmergencyName());
    }

    @Test
    void setEmergencyNumber() {
        editState.setEmergencyNumber("+987654321");
        assertEquals("+987654321", editState.getEmergencyNumber());
    }

    @Test
    void setEmergencyRelationship() {
        editState.setEmergencyRelationship("Friend");
        assertEquals("Friend", editState.getEmergencyRelationship());
    }
}
