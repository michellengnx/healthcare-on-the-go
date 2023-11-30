package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
/* TODO: Date is deprecated; look into alternative for util.Date */
import java.util.Date;


public class PatientTest {
    @Test
    public void testPatientConstructor() {
        final EmergencyContact emergencyContact = new EmergencyContact(
                "Michelle",
                "6473036832",
                "friend"
        );

        final CreditCard creditCard = new CreditCard(
                "000000000000",
                123,
                "Tomorrow",
                "Michelle N"
        );
        final Date birthday = new Date(2001, Calendar.DECEMBER,11);

        Patient p = new Patient(
                "patient",
                "patient",
                "patient@domain.com",
                "1111111111",
                "Female",
                "11111111",
                birthday,
                creditCard,
                emergencyContact
        );

        assertEquals("patient",p.getUsername());
        assertEquals("patient",p.getPassword());
        assertEquals("patient@domain.com",p.getEmail());
        assertEquals("1111111111",p.getPhoneNumber());
        assertEquals("Female",p.getGender());
        assertEquals("11111111",p.getInsurance());
        assertEquals(birthday,p.getBirthday());
        assertEquals(creditCard,p.getCreditCard());
        assertEquals(emergencyContact,p.getEmergencyContact());




    }
}
