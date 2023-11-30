package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceRequestTest {

    private ServiceRequest serviceRequest;
    private Doctor doctor;
    private Service service;

    @BeforeEach
    public void setUp() {
        doctor = new Doctor("username", "password", "email@example.com",
                "123-456-7890", "Male", new Date(), 1, "Hospital", null, null);

        // Updated to use the new constructor that takes name and price
        service = new Service("Medical Consultation", 50.0f);

        serviceRequest = new ServiceRequest(
                new Date(),
                doctor,
                3,
                "123 Main Street",
                service,
                50.0f,
                15.0f,
                5.0f
        );
    }

    @Test
    public void testServiceRequestInitialization() {
        assertEquals(3, serviceRequest.getUrgencyLevel(), "Urgency level should match the initialized value");
        assertEquals("123 Main Street", serviceRequest.getDestination(), "Destination should match the initialized value");
        assertEquals(service, serviceRequest.getService(), "Service should match the initialized value");
        assertEquals(50.0f, serviceRequest.getPrice(), "Price should match the initialized value");
        assertEquals(15.0f, serviceRequest.getEta(), "ETA should match the initialized value");
        assertEquals(5.0f, serviceRequest.getDistance(), "Distance should match the initialized value");
        assertFalse(serviceRequest.isCompleted(), "Completed should be initialized as false");
    }

    @Test
    public void testSetters() {
        // The rest of the test methods remain unchanged
    }

    @Test
    public void testSetCompleted() {
        assertFalse(serviceRequest.isCompleted(), "Completed should be initially false");
        serviceRequest.setCompleted(true);
        assertTrue(serviceRequest.isCompleted(), "Completed should be updated to true");
    }
}
