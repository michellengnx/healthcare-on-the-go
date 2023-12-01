package use_case.EditProfile;

import data_access.FilePatientDataAccessObject;
import entities.*;
import use_case.edit_profile.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EditProfileInteractorTest {
    private EditInputData editInputData;
    private EditPatientDataAccessInterface patientDataAccessInterface;

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
     * ensures there is at least 1 user in the CSV file for testing purposes
     */
    @BeforeEach
    public void addPatient() {
        FilePatientDataAccessObject fudao;
        try {
            // Clear the file content before adding a new patient
            PrintWriter writer = new PrintWriter("./users.csv");
            writer.print("");
            writer.close();

            fudao = new FilePatientDataAccessObject("./users.csv");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        fudao.save(samplePatient);
    }

    @Test
    void successTest() throws IOException, ParseException {
        EditOutputBoundary successPresenter = new EditOutputBoundary() {
            @Override
            public void prepareSuccessView(EditOutputData patient) {
                assertEquals(samplePatient.getUsername(), editInputData.getUsername());
                assertEquals(samplePatient.getPassword(), editInputData.getPassword());
                assertEquals(samplePatient.getEmail(), editInputData.getEmail());
                assertEquals(samplePatient.getPhoneNumber(), editInputData.getPhoneNumber());
                assertEquals(samplePatient.getInsurance(), editInputData.getInsurance());
                assertEquals(samplePatient.getCreditCard().getCreditCardNumber(), editInputData.getCreditCardNumber());
                assertEquals(samplePatient.getCreditCard().getCcv(), editInputData.getCvv());
                assertEquals(samplePatient.getCreditCard().getExpirationDate(), editInputData.getExpirationDate());
                assertEquals(samplePatient.getCreditCard().getNameOnCard(), editInputData.getNameOnCard());
                assertEquals(samplePatient.getEmergencyContact().getName(), editInputData.getEmergencyName());
                assertEquals(samplePatient.getEmergencyContact().getPhoneNumber(), editInputData.getEmergencyNumber());
                assertEquals(samplePatient.getEmergencyContact().getRelationship(), editInputData.getEmergencyRelationship());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");

            }

        };
        EditInputData inputData = new EditInputData(
                "patient1",
                "kayumova",
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
        patientDataAccessInterface = new FilePatientDataAccessObject("./user.csv");
        EditInputBoundary interactor = new EditInteractor(patientDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }
}
