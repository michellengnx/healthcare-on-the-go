package data_access;

import entities.Patient;
import entities.ServiceRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.CreateRequest.CreateRequestUserDataAccessInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FileUserRequestDataAccessInterfaceObjectTest {

    private FilePatientDataAccessObject filePatientDataAccessObject;
    private FileRequestDataAccessObject fileRequestDataAccessObject;
    private CreateRequestUserDataAccessInterface userDataAccessObject;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        filePatientDataAccessObject = mock(FilePatientDataAccessObject.class);
        fileRequestDataAccessObject = mock(FileRequestDataAccessObject.class);

        // Create instance of the class under test with mocked dependencies
        userDataAccessObject = new FileUserRequestDataAccessObject(filePatientDataAccessObject, fileRequestDataAccessObject);
    }

    @Test
    void saveRequest() {
        // Create a sample patient and service request
        Patient patient = new Patient("testPatient", "password", "email@example.com", "1234567890", "Male", "Insurance", null, null, null);
        ServiceRequest request = new ServiceRequest(null, null, 1, "Test Destination", null, 0, 0, 0);

        // Call the method under test
        userDataAccessObject.saveRequest(patient, request);

        // Verify that the method was called with the correct arguments
        verify(fileRequestDataAccessObject, times(1)).addRequest(request, patient.getUsername());
    }

    @Test
    void getPatient() {
        // Create a sample patient
        Patient expectedPatient = new Patient("testPatient", "password", "email@example.com", "1234567890", "Male", "Insurance", null, null, null);

        // Mock behavior
        when(filePatientDataAccessObject.get("testPatient")).thenReturn(expectedPatient);

        // Call the method under test
        Patient actualPatient = userDataAccessObject.getPatient("testPatient");

        // Verify that the expected patient is returned
        assertEquals(expectedPatient, actualPatient);
    }
}
