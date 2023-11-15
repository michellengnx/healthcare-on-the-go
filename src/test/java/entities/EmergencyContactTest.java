package entities;

import org.junit.Test;

public class EmergencyContactTest {
    @Test
    public void testEmergencyContactConstructor() {
        EmergencyContact emergencyContact = new EmergencyContact(
                "Michelle",
                "6473036832",
                "friend"
        );
        assert emergencyContact.getName().equals("Michelle");
        assert emergencyContact.getPhoneNumber().equals("6473036832");
        assert emergencyContact.getRelationship().equals("friend");

    }
}
