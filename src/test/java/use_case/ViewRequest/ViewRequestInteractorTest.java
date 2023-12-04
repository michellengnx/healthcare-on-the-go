package use_case.ViewRequest;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ViewRequestInteractorTest {

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

    private ServiceRequest request;
    private Patient oneRequestPatient;

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

        request = new ServiceRequest(
                new Date(),
                sampleDoctor,
                1,
                "dest",
                new Service("x-ray", 20),
                1,
                1,
                1
        );

        oneRequestPatient.getRequests().add(request);
    }

    /**
     * Test the general case, when viewing a request occurs successfully.
     */
    @Test
    public void successTest() {
        ViewRequestOutputBoundary successPresenter = new ViewRequestOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewRequestOutputData viewRequestOutputData) {
                assertEquals(1, viewRequestOutputData.getData().size());
                assertEquals("x-ray", viewRequestOutputData.getData().get(0).get(0));
            }

            @Override
            public void prepareFailView(String errorMsg) {
                fail("Use case failure is unexpected.");
            }
        };

        ViewRequestInputBoundary interactor = new ViewRequestInteractor(new RequestDataAccessObject(), successPresenter);
        interactor.execute(new ViewRequestInputData(oneRequestPatient.getUsername())); // This will eventually send Output Data to the successPresenter
    }


    /**
     * Synthetic request data access object.
     */
    private static class RequestDataAccessObject implements RequestDataAccessInterface {

        @Override
        public ArrayList<ArrayList<String>> getRequestUser(String userName) {
            ArrayList<ArrayList<String>> requestDetails = new ArrayList<>();
            requestDetails.add(new ArrayList<>());
            requestDetails.get(0).add("x-ray");
            return requestDetails;
        }

        @Override
        public void addRequest(ServiceRequest request, String userName) {

        }

        @Override
        public void clear() {

        }
    }

}
