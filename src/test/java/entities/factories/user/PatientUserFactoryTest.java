package entities.factories.user;

import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientUserFactoryTest {

    @Test
    void testCreatePatient() {
        // Sample data for testing
        String username = "testUser";
        String password = "testPassword";
        String email = "test@example.com";
        String phoneNumber = "123-456-7890";
        String gender = "Male";
        String insurance = "Health Insurance";
        Date birthday = new Date();

        String creditCardNumber = "1111222233334444";
        int ccv = 123;
        String expirationDate = "12/24";
        String nameOnCard = "Cardholder";

        String contactName = "Emergency Contact";
        String contactPhoneNumber = "987-654-3210";
        String contactRelationship = "Family";

        // Creating an instance of PatientUserFactory
        PatientUserFactory patientUserFactory = new PatientUserFactory();

        // Creating a patient using the factory
        Patient patient = patientUserFactory.create(
                username, password, email, phoneNumber, gender, insurance, birthday,
                creditCardNumber, ccv, expirationDate, nameOnCard,
                contactName, contactPhoneNumber, contactRelationship);

        // Testing the created patient object
        assertNotNull(patient);
        assertEquals(username, patient.getUsername());
        assertEquals(password, patient.getPassword());
        assertEquals(email, patient.getEmail());
        assertEquals(phoneNumber, patient.getPhoneNumber());
        assertEquals(gender, patient.getGender());
        assertEquals(insurance, patient.getInsurance());
        assertEquals(birthday, patient.getBirthday());

        CreditCard creditCard = patient.getCreditCard();
        assertNotNull(creditCard);
        assertEquals(creditCardNumber, creditCard.getCreditCardNumber());
        assertEquals(ccv, creditCard.getCcv());
        assertEquals(expirationDate, creditCard.getExpirationDate());
        assertEquals(nameOnCard, creditCard.getNameOnCard());

        EmergencyContact emergencyContact = patient.getEmergencyContact();
        assertNotNull(emergencyContact);
        assertEquals(contactName, emergencyContact.getName());
        assertEquals(contactPhoneNumber, emergencyContact.getPhoneNumber());
        assertEquals(contactRelationship, emergencyContact.getRelationship());
    }
}
