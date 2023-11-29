package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    private Doctor doctor;

    @BeforeEach
    public void setUp() {
        // Set up a sample Doctor object for testing
        List<String> certifications = Arrays.asList("Cert1", "Cert2");
        List<Service> qualifiedServices = Arrays.asList(new Service("Service1", 100), new Service("Service2", 100));

        doctor = new Doctor("username", "password", "email@example.com",
                "123-456-7890", "Male", new Date(), 1, "Hospital", certifications, qualifiedServices);
    }

    @Test
    public void testGetLocation() {
        assertEquals("Hospital", doctor.getLocation(), "Location should match the initialized value");
    }

    @Test
    public void testGetCertifications() {
        List<String> expectedCertifications = Arrays.asList("Cert1", "Cert2");
        assertEquals(expectedCertifications, doctor.getCertifications(), "Certifications should match the initialized value");
    }


    @Test
    public void testDoctorInitialization() {
        assertNotNull(doctor, "Doctor object should be initialized");
        assertEquals("username", doctor.getUsername(), "Username should match the initialized value");
        // Add more assertions as needed for other properties
    }
}
