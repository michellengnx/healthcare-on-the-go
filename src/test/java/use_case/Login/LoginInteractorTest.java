package use_case.Login;

import data_access.FilePatientDataAccessObject;
import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the EditInteractor that handles editing a patient's profile.
 */
public class LoginInteractorTest {
    private LoginUserDataAccessInterface loginUserDataAccessInterface;
    private LoginOutputBoundary successPresenter;
    private LoginOutputBoundary failIncorrectPasswordPresenter;
    private LoginOutputBoundary failIncorrectUsernamePresenter;


    private final Patient samplePatient = new Patient(
            "patient1",
            "pqd2004@",
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

            loginUserDataAccessInterface = new FilePatientDataAccessObject("./users.csv");
            loginUserDataAccessInterface.save(samplePatient);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test to verify successful editing of a patient's profile.
     */
    @Test
    void successTest() {
        LoginInputData inputData = new LoginInputData(
                "patient1",
                "pqd2004@");

        successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData patient) {
                assertEquals(samplePatient.getUsername(), patient.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");

            }
        };

        LoginInputBoundary interactor = new LoginInteractor(loginUserDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureIncorrectPasswordTest() {
        LoginInputData inputData = new LoginInputData(
                "patient1",
                "pqd2004");

        failIncorrectPasswordPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData patient) {
                fail("Use case failure is expected");
            }

            @Override
            public void prepareFailView(String error) {
                assertNotEquals(error, null);

            }
        };

        LoginInputBoundary interactor = new LoginInteractor(loginUserDataAccessInterface, failIncorrectPasswordPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureIncorrectUsernameTest() {
        LoginInputData inputData = new LoginInputData(
                "patient2",
                "pqd2004");

        failIncorrectUsernamePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData patient) {
                fail("Use case failure is expected");
            }

            @Override
            public void prepareFailView(String error) {
                assertNotEquals(samplePatient.getUsername(), inputData.getUsername());

            }
        };

        LoginInputBoundary interactor = new LoginInteractor(loginUserDataAccessInterface, failIncorrectUsernamePresenter);
        interactor.execute(inputData);
    }
}
