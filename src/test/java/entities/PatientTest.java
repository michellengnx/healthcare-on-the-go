package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PatientTest {

    @Test
    void testPatientInitialization() {
        // Create a sample CreditCard object
        CreditCard creditCard = new CreditCard("1234567890123456", 123, "12/25", "John Doe");

        // Create a sample EmergencyContact object
        EmergencyContact emergencyContact = new EmergencyContact("Jane Doe", "9876543210", "Friend");

        // Create a sample Patient object
        Patient patient = new Patient(
                "testUser",
                "testPassword",
                "test@example.com",
                "1234567890",
                "Male",
                "Insurance123",
                new Date(),
                creditCard,
                emergencyContact
        );

        // Check if the Patient object is initialized correctly
        assertNotNull(patient);
        assertEquals("testUser", patient.getUsername());
        assertEquals("testPassword", patient.getPassword());
        assertEquals("test@example.com", patient.getEmail());
        assertEquals("1234567890", patient.getPhoneNumber());
        assertEquals("Male", patient.getGender());
        assertEquals("Insurance123", patient.getInsurance());
        assertEquals(creditCard, patient.getCreditCard());
        assertEquals(emergencyContact, patient.getEmergencyContact());
        assertNotNull(patient.getRequests());
        assertEquals(0, patient.getRequests().size());

//        Modify

        // Modify the CreditCard and EmergencyContact of the Patient
        CreditCard newCreditCard = new CreditCard("9876543210987654", 456, "01/30", "New Card");
        EmergencyContact newEmergencyContact = new EmergencyContact("New Contact", "1234567890", "Family");

        patient.setBirthday(new Date());
        patient.setUsername("newUsername");
        patient.setGender("Female");
        patient.setCreditCard(newCreditCard);
        patient.setEmergencyContact(newEmergencyContact);

        // Check if modifications are applied correctly
        assertEquals(new Date(), patient.getBirthday());
        assertEquals("newUsername",patient.getUsername());
        assertEquals("Female",patient.getGender());
        assertEquals(newCreditCard, patient.getCreditCard());
        assertEquals(newEmergencyContact, patient.getEmergencyContact());

        // Create a sample ServiceRequest
        ServiceRequest serviceRequest = new ServiceRequest(
                new Date(),
                new Doctor("doctorUsername", "doctorPassword", "doctor@example.com",
                        "9876543210", "Male", new Date(), 1, "Hospital",
                        new ArrayList<>(), new ArrayList<>()),
                1, "Hospital", new Service("Test Service", 50.0f), 50.0f, 30.0f, 10.0f
        );

        // Add the ServiceRequest to the Patient's requests
        ArrayList<ServiceRequest> requests = new ArrayList<>();
        requests.add(serviceRequest);
        patient.setRequests(requests);

        // Check if the ServiceRequest is added correctly
        assertEquals(1, patient.getRequests().size());
        assertEquals(serviceRequest, patient.getRequests().get(0));
    }
}
