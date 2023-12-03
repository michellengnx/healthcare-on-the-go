package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceRequestTest {

    private ServiceRequest serviceRequest;

    @BeforeEach
    void setUp() {
        ArrayList<String> certifications = new ArrayList<>();
        certifications.add("Certification A");
        certifications.add("Certification B");

        ArrayList<Service> qualifiedServices = new ArrayList<>();
        qualifiedServices.add(new Service("Service A", 19.99f));
        qualifiedServices.add(new Service("Service B", 24.99f));



        // Common setup for each test
        Date creationTime = new Date();
        Doctor doctor = new Doctor("username", "password", "email@example.com",
                "123-456-7890", "Male", new Date(), 1, "Hospital",
                certifications, qualifiedServices);
        int urgencyLevel = 1;
        String destination = "Initial Destination";
        Service service = new Service("Initial Service", 15.99f);
        float price = 20.0f;
        float eta = 25.0f;
        float distance = 8.0f;

        serviceRequest = new ServiceRequest(
                creationTime, doctor, urgencyLevel, destination, service, price, eta, distance
        );
    }

    @Test
    void testServiceRequestConstructorAndGetters() {
        // Assert
        assertEquals(new Date(), serviceRequest.getCreationTime());
        assertEquals("username", serviceRequest.getDoctor().getUsername());
        assertEquals(1, serviceRequest.getUrgencyLevel());
        assertEquals("Initial Destination", serviceRequest.getDestination());
        assertEquals("Initial Service - $15.99", serviceRequest.getService().toString());

        assertEquals(20.0f, serviceRequest.getPrice(), 0.01);
        assertEquals(25.0f, serviceRequest.getEta(), 0.01);
        assertEquals(8.0f, serviceRequest.getDistance(), 0.01);
        assertFalse(serviceRequest.isCompleted());
    }

    @Test
    void testServiceRequestSetters() {
        // Act
        Date newCreationTime = new Date();

        List<String> certifications = Arrays.asList("Cert1", "Cert2");
        List<Service> qualifiedServices = Arrays.asList(new Service("Service1", 100), new Service("Service2", 100));

        Doctor newDoctor = new Doctor("updatedUsername", "updatedPassword",
                "email@example.com", "123-456-7890",
                "Male", new Date(), 1, "Hospital",
                certifications, qualifiedServices);

        int newUrgencyLevel = 3;
        String newDestination = "Updated Destination";
        Service newService = new Service("Updated Service", 29.99f);
        float newPrice = 30.99f;
        float newEta = 35.0f;
        float newDistance = 15.0f;
        boolean newCompleted = true;

        serviceRequest.setCreationTime(newCreationTime);
        serviceRequest.setDoctor(newDoctor);
        serviceRequest.setUrgencyLevel(newUrgencyLevel);
        serviceRequest.setDestination(newDestination);
        serviceRequest.setService(newService);
        serviceRequest.setPrice(newPrice);
        serviceRequest.setEta(newEta);
        serviceRequest.setDistance(newDistance);
        serviceRequest.setCompleted(newCompleted);

        // Assert
        assertEquals(newCreationTime, serviceRequest.getCreationTime());
        assertEquals(newDoctor.getUsername(), serviceRequest.getDoctor().getUsername());
        assertEquals(newUrgencyLevel, serviceRequest.getUrgencyLevel());
        assertEquals(newDestination, serviceRequest.getDestination());
        assertEquals(newService, serviceRequest.getService());
        assertEquals(newPrice, serviceRequest.getPrice(), 0.01);
        assertEquals(newEta, serviceRequest.getEta(), 0.01);
        assertEquals(newDistance, serviceRequest.getDistance(), 0.01);
        assertTrue(serviceRequest.isCompleted());
    }
}
