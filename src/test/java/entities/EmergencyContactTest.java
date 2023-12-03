package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmergencyContactTest {

    @Test
    void testEmergencyContactConstructorAndGetters() {
        // Arrange
        String name = "John Doe";
        String phoneNumber = "1234567890";
        String relationship = "Friend";

        // Act
        EmergencyContact emergencyContact = new EmergencyContact(name, phoneNumber, relationship);

        // Assert
        assertEquals(name, emergencyContact.getName());
        assertEquals(phoneNumber, emergencyContact.getPhoneNumber());
        assertEquals(relationship, emergencyContact.getRelationship());
    }

    @Test
    void testEmergencyContactSetters() {
        // Arrange
        EmergencyContact emergencyContact = new EmergencyContact("John Doe", "1234567890", "Friend");

        // Act
        String newName = "Jane Doe";
        String newPhoneNumber = "9876543210";
        String newRelationship = "Family";

        emergencyContact.setName(newName);
        emergencyContact.setPhoneNumber(newPhoneNumber);
        emergencyContact.setRelationship(newRelationship);

        // Assert
        assertEquals(newName, emergencyContact.getName());
        assertEquals(newPhoneNumber, emergencyContact.getPhoneNumber());
        assertEquals(newRelationship, emergencyContact.getRelationship());
    }
}
