package use_case.ResolveRequest;

import entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

class ResolveRequestInteractorTest {
    private final Doctor sampleDoctor = new Doctor(
            "doc",
            "pass1",
            "mail1@mail.com",
            "123-123-1231",
            "male",
            new Date(),
            1,
            "23 Road Lane",
            new ArrayList<>(),
            new ArrayList<>());

    private final ServiceRequest request = new ServiceRequest(
            new Date(),
            sampleDoctor,
            1,
            "dest",
            new Service("x-ray", 20),
            1,
            1,
            1
    );
    private Patient oneRequestPatient = new Patient(
            "patient1",
            "pass1",
            "patient@mail.com",
            "123-123-1231",
            "male",
            "ins.",
            new Date(),
            new CreditCard(
                    "1234567890",
                    123,
                    "09/12",
                    "patient smith"),
            new EmergencyContact("dad smith", "123-123-1231", "dad"));

    @BeforeEach
    public void init() {
        oneRequestPatient = new Patient(
                "patient1",
                "pass1",
                "patient@mail.com",
                "123-123-1231",
                "male",
                "ins.",
                new Date(),
                new CreditCard(
                        "1234567890",
                        123,
                        "09/12",
                        "patient smith"),
                new EmergencyContact("dad smith", "123-123-1231", "dad"));


        oneRequestPatient.getRequests().add(request);
    }

    /**
     * Test the general case, when resolving a request occurs successfully.
     */
    @Test
    public void successTest() {
        ResolveRequestOutputBoundary successPresenter = new ResolveRequestOutputBoundary() {
            @Override
            public void prepareSuccessView(ResolveRequestOutputData response) {
                ServiceRequest request = response.getRequest();
                Patient patient = response.getPatient();
                assertTrue(request.isCompleted());
                assertEquals(request, patient.getRequests().get(0));
            }

            @Override
            public void prepareFailView(String errorMsg) {
                fail("Use case failure is unexpected.");
            }
        };

        ResolveRequestInputBoundary interactor = new ResolveRequestInteractor(
                new UserDataAccessObject(), successPresenter);
        interactor.execute(new ResolveRequestInputData(oneRequestPatient, oneRequestPatient.getRequests().get(0))); // This will eventually send Output Data to the successPresenter
    }

    /**
     * Test the case when the data access object is unable to find the given request associated with a patient.
     */
    @Test
    public void failTest() {
        ResolveRequestOutputBoundary successPresenter = new ResolveRequestOutputBoundary() {
            @Override
            public void prepareSuccessView(ResolveRequestOutputData response) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String errorMsg) {
            }
        };

        ResolveRequestInputBoundary interactor = new ResolveRequestInteractor(
                new ExceptionUserDataAccessObject(), successPresenter);
        interactor.execute(new ResolveRequestInputData(oneRequestPatient, oneRequestPatient.getRequests().get(0))); // This will eventually send Output Data to the successPresenter
    }

    private static class UserDataAccessObject implements ResolveRequestUserDataAccessInterface {

        @Override
        public void resolveRequest(Patient patient, ServiceRequest request) throws NoRequestFoundException {
            request.setCompleted(true);
        }
    }

    private static class ExceptionUserDataAccessObject implements ResolveRequestUserDataAccessInterface {

        @Override
        public void resolveRequest(Patient patient, ServiceRequest request) throws NoRequestFoundException {
            throw new NoRequestFoundException();
        }
    }
}