package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmergencyContactTest {
    @Test
    public void testEmergencyContactConstructor() {
        EmergencyContact emergencyContact = new EmergencyContact(
                "Michelle",
                "6473036832",
                "friend"
        );
        assertEquals("Michelle",emergencyContact.getName());
        assertEquals("6473036832",emergencyContact.getPhoneNumber());
        assertEquals("friend",emergencyContact.getRelationship());
    }
}
