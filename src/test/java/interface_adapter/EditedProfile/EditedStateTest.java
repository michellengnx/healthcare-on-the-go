package interface_adapter.EditedProfile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EditedStateTest {

    private EditedState editedState;

    @BeforeEach
    public void setUp() {
        // Set up common state for tests
        editedState = new EditedState();
        editedState.setPassword("newPassword");
        editedState.setEmail("newEmail@example.com");
        editedState.setPhoneNumber("1234567890");
        editedState.setInsurance("NewInsurance");
        editedState.setCreditCardNumber("1234-5678-9101-1121");
        editedState.setCvv(123);
        editedState.setExpirationDate("12/23");
        editedState.setNameOnCard("John Doe");
        editedState.setEmergencyName("Emergency Contact");
        editedState.setEmergencyNumber("9876543210");
        editedState.setEmergencyRelationship("Friend");
    }

    @Test
    public void testDefaultConstructor() {
        // Create an EditedState object using the default constructor
        EditedState defaultState = new EditedState();

        // Check if the values are initialized correctly
        assertEquals("", defaultState.getPassword());
        assertEquals("", defaultState.getEmail());
        assertEquals("", defaultState.getPhoneNumber());
        assertEquals("", defaultState.getInsurance());
        assertEquals("", defaultState.getCreditCardNumber());
        assertEquals(0, defaultState.getCvv());
        assertEquals("", defaultState.getExpirationDate());
        assertEquals("", defaultState.getNameOnCard());
        assertEquals("", defaultState.getEmergencyName());
        assertEquals("", defaultState.getEmergencyNumber());
        assertEquals("", defaultState.getEmergencyRelationship());
    }

    @Test
    public void testGetters() {
        // Check if the values are retrieved correctly using getters
        assertEquals("newPassword", editedState.getPassword());
        assertEquals("newEmail@example.com", editedState.getEmail());
        assertEquals("1234567890", editedState.getPhoneNumber());
        assertEquals("NewInsurance", editedState.getInsurance());
        assertEquals("1234-5678-9101-1121", editedState.getCreditCardNumber());
        assertEquals(123, editedState.getCvv());
        assertEquals("12/23", editedState.getExpirationDate());
        assertEquals("John Doe", editedState.getNameOnCard());
        assertEquals("Emergency Contact", editedState.getEmergencyName());
        assertEquals("9876543210", editedState.getEmergencyNumber());
        assertEquals("Friend", editedState.getEmergencyRelationship());
    }

    @Test
    public void testSetters() {
        // Change values using setters
        editedState.setPassword("updatedPassword");
        editedState.setEmail("updatedEmail@example.com");
        editedState.setPhoneNumber("9876543210");
        editedState.setInsurance("UpdatedInsurance");
        editedState.setCreditCardNumber("9876-5432-1098-7654");
        editedState.setCvv(456);
        editedState.setExpirationDate("01/25");
        editedState.setNameOnCard("Jane Doe");
        editedState.setEmergencyName("New Emergency Contact");
        editedState.setEmergencyNumber("1234567890");
        editedState.setEmergencyRelationship("Family");

        // Check if the values are set correctly
        assertEquals("updatedPassword", editedState.getPassword());
        assertEquals("updatedEmail@example.com", editedState.getEmail());
        assertEquals("9876543210", editedState.getPhoneNumber());
        assertEquals("UpdatedInsurance", editedState.getInsurance());
        assertEquals("9876-5432-1098-7654", editedState.getCreditCardNumber());
        assertEquals(456, editedState.getCvv());
        assertEquals("01/25", editedState.getExpirationDate());
        assertEquals("Jane Doe", editedState.getNameOnCard());
        assertEquals("New Emergency Contact", editedState.getEmergencyName());
        assertEquals("1234567890", editedState.getEmergencyNumber());
        assertEquals("Family", editedState.getEmergencyRelationship());
    }

    @Test
    public void testCopyConstructor() {
        // Create a new EditedState object using the copy constructor
        EditedState copiedState = new EditedState(editedState);

        // Check if the values are copied correctly
        assertEquals("newPassword", copiedState.getPassword());
        assertEquals("newEmail@example.com", copiedState.getEmail());
        assertEquals("1234567890", copiedState.getPhoneNumber());
        assertEquals("NewInsurance", copiedState.getInsurance());
        assertEquals("1234-5678-9101-1121", copiedState.getCreditCardNumber());
        assertEquals(123, copiedState.getCvv());
        assertEquals("12/23", copiedState.getExpirationDate());
        assertEquals("John Doe", copiedState.getNameOnCard());
        assertEquals("Emergency Contact", copiedState.getEmergencyName());
        assertEquals("9876543210", copiedState.getEmergencyNumber());
        assertEquals("Friend", copiedState.getEmergencyRelationship());
    }
}
