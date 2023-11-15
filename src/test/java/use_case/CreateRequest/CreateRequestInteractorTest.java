package use_case.CreateRequest;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateRequestInteractorTest {
    private CreateRequestInputData inputData;
    private CreateRequestApiAccessInterface apiAccessObject;
    private CreateRequestDoctorDataAccessInterface doctorRepository;
    private CreateRequestUserDataAccessInterface patientRepository;
    private CreateRequestDoctorDataAccessInterface emptyDoctorRepository;
    private CreateRequestApiAccessInterface invalidApiAccessObject;

    /**
     * Initialize an input data object, and common data access objects.
     */
    @BeforeEach
    void init() {
         // random input data object
         inputData = new CreateRequestInputData(
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
        // Synthetic data access objects
        apiAccessObject = new ApiAccessObject();
        doctorRepository = new DoctorAccessObject();
        patientRepository = new UserAccessObject();
        emptyDoctorRepository = new EmptyDoctorAcessObject();
        invalidApiAccessObject = new InvalidApiAccessObject();
    }

    /**
     * Test the case when the interactor should call prepareSuccessView on the presenter
     */
    @Test
    void successTest() {
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

        CreateRequestInputBoundary interactor = new CreateRequestInteractor(
                apiAccessObject, doctorRepository, patientRepository, successPresenter);
        interactor.execute(this.inputData); // This will eventually send Output Data to the successPresenter
    }

    @Test
    void failTestNoDoctor() {
        // Synthetic output boundary that ensure prepareSuccessView is called, and that the response data is accurate
        CreateRequestOutputBoundary failPresenter = new CreateRequestOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateRequestOutputData response) {
                fail("Use case failure is excepted");
            }

            @Override
            public void prepareFailView(String error) {
               return;
            }
        };

        CreateRequestInputBoundary interactor = new CreateRequestInteractor(
                apiAccessObject, emptyDoctorRepository, patientRepository, failPresenter);
        interactor.execute(this.inputData); // This will eventually send Output Data to the failPresenter
    }

    @Test
    void failTestInvalidLocation() {
        // Synthetic output boundary that ensure prepareSuccessView is called, and that the response data is accurate
        CreateRequestOutputBoundary failPresenter = new CreateRequestOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateRequestOutputData response) {
                fail("Use case failure is excepted");
            }

            @Override
            public void prepareFailView(String error) {
                return;
            }
        };

        CreateRequestInputBoundary interactor = new CreateRequestInteractor(
                invalidApiAccessObject, doctorRepository, patientRepository, failPresenter);
        interactor.execute(this.inputData); // This will eventually send Output Data to the failPresenter
    }

    /**
     * Synthetic DAO that returns arbitrary numbers.
     */
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

    /**
     * Synthetic DAO that always throws an InvalidLocationException
     */
    private static class InvalidApiAccessObject implements CreateRequestApiAccessInterface {
        @Override
        public float getDistance(String startLoc, String endLoc) throws InvalidLocationException {
            throw new InvalidLocationException("Location invalid");
        }

        @Override
        public float getEta(String startLoc, String endLoc) throws InvalidLocationException {
            throw new InvalidLocationException("Location invalid");
        }

        @Override
        public float getPrice(String startLoc, String endLoc) throws InvalidLocationException {
            throw new InvalidLocationException("Location invalid");
        }
    }

    /**
     * Synthetic DAO that does nothing
     */
    private static class UserAccessObject implements CreateRequestUserDataAccessInterface {

        @Override
        public void saveRequest(Patient patient, ServiceRequest request) {
        }
    }

    /**
     * Synthetic DAO that returns a doctor list with 1 doctor
     */
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
                    new ArrayList<>(),
                    new ArrayList<>()));

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

    /**
     * Synthetic DAO that returns empty doctor lists
     */
    private static class EmptyDoctorAcessObject implements CreateRequestDoctorDataAccessInterface {

        @Override
        public List<Doctor> getAvailableDoctors() {
            return new ArrayList<>();
        }

        @Override
        public List<Doctor> getAvailableDoctors(Service service) {
            return new ArrayList<>();
        }

        @Override
        public void markAsBusy(Doctor doctor) {
        }
    }
}

