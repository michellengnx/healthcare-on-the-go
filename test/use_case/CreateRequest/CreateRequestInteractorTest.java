package use_case.CreateRequest;

import entities.*;
import interface_adapter.CreateRequest.CreateRequestPresenter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateRequestInteractorTest {
    /**
     * Test the case when the interactor should call prepareSuccessView on the presenter
     */
    @Test
    void successTest() {
        // Synthetic data access objects
        CreateRequestApiAccessInterface apiAccessObject = new ApiAccessObject();
        CreateRequestDoctorDataAccessInterface doctorRepository = new DoctorAccessObject();
        CreateRequestUserDataAccessInterface patientRepository = new UserAccessObject();

        // Synthetic output boundary that ensure prepareSuccessView is called, and that the response data is accurate
        CreateRequestOutputBoundary successPresenter = new CreateRequestOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateRequestOutputData response) {
                ServiceRequest request = response.getRequest();
                assertEquals("doc1", request.getDoctor().getUsername());
                assertEquals(240, request.getPrice());
                assertEquals("123 Street Avenue", request.getDestination());
                assertEquals(30, request.getEta());
                assertEquals("X-ray", request.getService().getName());
                assertEquals(20, request.getDistance());
                assertEquals(1, request.getUrgencyLevel());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        // random input data object
        CreateRequestInputData inputData = new CreateRequestInputData(
                new Date(),
                1,
                "123 Street Avenue",
                new Service("X-ray", 200),
                new Patient(
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
                        new EmergencyContact("dad smith", "123-123-1231", "dad"))
        );
        CreateRequestInputBoundary interactor = new CreateRequestInteractor(
                apiAccessObject, doctorRepository, patientRepository, successPresenter);
        interactor.execute(inputData); // This will eventually send Output Data to the successPresenter
    }

    private static class ApiAccessObject implements CreateRequestApiAccessInterface {
        @Override
        public float getDistance(String startLoc, String endLoc) {
            return 20;
        }

        @Override
        public float getEta(String startLoc, String endLoc) {
            return 30;
        }

        @Override
        public float getPrice(String startLoc, String endLoc) {
            return 40;
        }
    }

    private static class UserAccessObject implements CreateRequestUserDataAccessInterface {

        @Override
        public void saveRequest(Patient patient, ServiceRequest request) {
        }
    }

    private static class DoctorAccessObject implements CreateRequestDoctorDataAccessInterface {

        @Override
        public List<Doctor> getAvailableDoctors() {
            List<Doctor> dummyDoctorList = new ArrayList<>();
            dummyDoctorList.add(new Doctor(
                    "doc1",
                    "pass1",
                    "mail1@mail.com",
                    "123-123-1231",
                    "male",
                    new Date(),
                    1,
                    "23 Road Lane",
                    new ArrayList<String>(),
                    new ArrayList<Service>()));

            return dummyDoctorList;
        }

        @Override
        public List<Doctor> getAvailableDoctors(Service service) {
            return null;
        }

        @Override
        public void markAsBusy(Doctor doctor) {

        }
    }
}

