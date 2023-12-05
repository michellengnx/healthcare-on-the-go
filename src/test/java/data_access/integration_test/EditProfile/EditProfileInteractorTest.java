package data_access.integration_test.EditProfile;

import data_access.FilePatientDataAccessObject;
import entities.*;
import use_case.edit_profile.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class for the EditInteractor that handles editing a patient's profile.
 */
public class EditProfileInteractorTest {
    private EditPatientDataAccessInterface patientDataAccessInterface;
    private EditOutputBoundary successPresenter;

    private final Patient samplePatient = new Patient(
            "patient1",
            "pqd2004",
            "patient@mail.com",
            "123-456-7891",
            "male",
            "insurance",
            new Date(),
            new CreditCard(
                    "1234567890",
                    123,
                    "09/12",
                    "patient smith"),
            new EmergencyContact("dad smith", "123-123-1234", "dad"));

    /**
     * Sets up the test environment by adding a sample patient to the file data access object.
     */
    @BeforeEach
    public void addPatient() {
        try {
            PrintWriter writer = new PrintWriter("./users.csv");
            writer.print("");
            writer.close();

            patientDataAccessInterface = new FilePatientDataAccessObject("./users.csv");
            patientDataAccessInterface.save(samplePatient);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test to verify successful editing of a patient's profile.
     */
    @Test
    void successTest() {
        EditInputData inputData = new EditInputData(
                "patient1",
                "Abcd123@",
                "izora.kayumova@mail.utoronto.ca",
                "437-241-3083",
                "GSC Everywhere",
                "0123456789",
                456,
                "08/26",
                "patient Eve",
                "mama Smith",
                "125-125-1235",
                "mom");

        successPresenter = new EditOutputBoundary() {
            @Override
            public void prepareSuccessView(EditOutputData patient) {
                assertEquals(samplePatient.getUsername(), inputData.getUsername());
                assertEquals(samplePatient.getPassword(), inputData.getPassword());
                assertEquals(samplePatient.getEmail(), inputData.getEmail());
                assertEquals(samplePatient.getPhoneNumber(), inputData.getPhoneNumber());
                assertEquals(samplePatient.getInsurance(), inputData.getInsurance());
                assertEquals(samplePatient.getCreditCard().getCreditCardNumber(), inputData.getCreditCardNumber());
                assertEquals(samplePatient.getCreditCard().getCcv(), inputData.getCvv());
                assertEquals(samplePatient.getCreditCard().getExpirationDate(), inputData.getExpirationDate());
                assertEquals(samplePatient.getCreditCard().getNameOnCard(), inputData.getNameOnCard());
                assertEquals(samplePatient.getEmergencyContact().getName(), inputData.getEmergencyName());
                assertEquals(samplePatient.getEmergencyContact().getPhoneNumber(), inputData.getEmergencyNumber());
                assertEquals(samplePatient.getEmergencyContact().getRelationship(), inputData.getEmergencyRelationship());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };

        EditInputBoundary interactor = new EditInteractor(patientDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }
}
