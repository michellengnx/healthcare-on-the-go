package interface_adapter.CreateRequest;

import entities.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CreateRequestStateTest {

    private CreateRequestState createRequestState;

    @BeforeEach
    void setUp() {
        createRequestState = new CreateRequestState();
    }

    @Test
    void getUrgencyLevel() {
        createRequestState.setUrgencyLevel(2);
        assertEquals(2, createRequestState.getUrgencyLevel());
    }

    @Test
    void getDestination() {
        createRequestState.setDestination("Hospital A");
        assertEquals("Hospital A", createRequestState.getDestination());
    }

    @Test
    void getService() {
        Service service = new Service("Ambulance", 50);
        createRequestState.setService(service);
        assertEquals(service, createRequestState.getService());
    }

    @Test
    void getPatient() {
        createRequestState.setPatient("John Doe");
        assertEquals("John Doe", createRequestState.getPatient());
    }

    @Test
    void getCreateRequestError() {
        createRequestState.setCreateRequestError("Invalid destination");
        assertEquals("Invalid destination", createRequestState.getCreateRequestError());
    }

    @Test
    void setUrgencyLevel() {
        createRequestState.setUrgencyLevel(3);
        assertEquals(3, createRequestState.getUrgencyLevel());
    }

    @Test
    void setDestination() {
        createRequestState.setDestination("Emergency Room");
        assertEquals("Emergency Room", createRequestState.getDestination());
    }

    @Test
    void setService() {
        Service service = new Service("X-ray", 30);
        createRequestState.setService(service);
        assertEquals(service, createRequestState.getService());
    }

    @Test
    void setPatient() {
        createRequestState.setPatient("Jane Doe");
        assertEquals("Jane Doe", createRequestState.getPatient());
    }

    @Test
    void setCreateRequestError() {
        createRequestState.setCreateRequestError("Invalid service");
        assertEquals("Invalid service", createRequestState.getCreateRequestError());
    }
}
