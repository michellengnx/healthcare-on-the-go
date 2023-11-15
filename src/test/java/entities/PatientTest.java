package entities;

import org.junit.Test;

import java.util.Calendar;
/* TODO: Date is deprecated; look into alternative for util.Date */
import java.util.Date;

public class PatientTest {
    @Test
    public void testPatientConstructor() {
        EmergencyContact emergencyContact = new EmergencyContact(
                "Michelle",
                "6473036832",
                "friend"
        );

        CreditCard creditCard = new CreditCard(
                "000000000000",
                123,
                "Tomorrow",
                "Michelle N"

        );

        Patient p = new Patient(
                "michelle",
                "michelle",
                "michellenguyen1608@gmail.com",
                "6473036832",
                "Female",
                "11111111",
                new Date(2000, Calendar.AUGUST,16),
                creditCard,
                emergencyContact

        );
    }
}
