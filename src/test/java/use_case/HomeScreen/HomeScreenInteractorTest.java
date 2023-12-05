package use_case.HomeScreen;

import entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

class HomeScreenInteractorTest {
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
     * Test the general case, when resolving a request occurs successfully.
     */
    @Test
    public void successTest() {
        HomeScreenOutputBoundary successPresenter = new HomeScreenOutputBoundary() {
            /**
             * Switch the current view to viewName.
             *
             * @param outputData
             */
            @Override
            public void prepareSuccessView(HomeScreenOutputData outputData) {
                assertNotEquals(outputData.getViewName(),"");
            }

        };

        HomeScreenInputBoundary interactor = new HomeScreenInteractor(successPresenter);
        interactor.execute(new HomeScreenInputData("viewName")); // This will eventually send Output Data to the successPresenter
    }

    /**
     * Test the case when the data access object is unable to find the given request associated with a patient.
     */
//    @Test
//    public void failTest() {
//        ResolveRequestOutputBoundary successPresenter = new ResolveRequestOutputBoundary() {
//            @Override
//            public void prepareSuccessView() {
//                fail("Use case failure is unexpected.");
//            }
//
//            @Override
//            public void prepareFailView(String errorMsg) {
//            }
//        };

//        HomeScreenInputBoundary interactor = new HomeScreenInteractor(successPresenter);
//        interactor.execute(new HomeScreenInputData(oneRequestPatient, oneRequestPatient.getRequests().get(0))); // This will eventually send Output Data to the successPresenter



}