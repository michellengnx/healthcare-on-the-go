package data_access;

import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.EditProfile.EditPatientDataAccessInterface;

import java.text.ParseException;
import java.util.Date;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FilePatientDataAccessObjectTest {
    private EditPatientDataAccessInterface dataAccessObject;


    @BeforeEach
    public void setUp() {
        try {
            PrintWriter writer = new PrintWriter("./patient_data.csv");
            writer.print("");
            writer.close();

            dataAccessObject = new FilePatientDataAccessObject("./patient_data.csv");

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void savePatientTest() {
        Patient patient = new Patient(
                "test_patient",
                "Test@1234",
                "test@example.com",
                "123-456-7890",
                "male",
                "insurance",
                new Date(),
                new CreditCard(
                        "1234567890123456",
                        123,
                        "01/23",
                        "Test Patient"),
                new EmergencyContact(
                        "Test Emergency",
                        "987-654-3210",
                        "Emergency"));

        dataAccessObject.save(patient);
        Patient retrievedPatient = dataAccessObject.get("test_patient");
        assertNotNull(retrievedPatient);
        assertEquals(patient.getUsername(), retrievedPatient.getUsername());
        // Add more assertions to validate other attributes
    }

    @Test
    public void getPasswordValidationTest() {
        assertTrue(dataAccessObject.hasValidPassword("StrongP@ss1"));
        assertFalse(dataAccessObject.hasValidPassword("weakpass"));
        assertFalse(dataAccessObject.hasValidPassword("missingNumber@"));
        assertFalse(dataAccessObject.hasValidPassword("NoSpecial123"));
        // Add more password validation scenarios
    }

    @Test
    public void editProfileTest() {
        Patient patient = dataAccessObject.get("test_patient");

        Integer[] changes = dataAccessObject.editProfile(
                "test_patient",
                "CSC207",
                "test@example.com",
                "437-241-3083",
                "GSC Everywhere",
                "0123456789",
                456,
                "08/26",
                "patient Eve",
                "mama Smith",
                "125-125-1235",
                "mom");

        assertNotNull(patient);
        assertEquals(-1, changes[0]);
        assertEquals(0, changes[1]);
        assertEquals(1, changes[2]);
        assertEquals(1, changes[3]);
        assertEquals(1, changes[4]);
        assertEquals(1, changes[5]);
    }
}