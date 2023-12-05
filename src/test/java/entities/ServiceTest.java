package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    void testServiceConstructorAndGetters() {
        // Arrange
        String serviceName = "Test Service";
        float servicePrice = 19.99f;

        // Act
        Service service = new Service(serviceName, servicePrice);

        // Assert
        assertEquals(serviceName, service.getName());
        assertEquals(servicePrice, service.getPrice(), 0.01); // Using a delta for float comparison
    }

    @Test
    void testServiceSetters() {
        // Arrange
        Service service = new Service("Initial Service", 25.50f);

        // Act
        String newServiceName = "Updated Service";
        float newServicePrice = 29.99f;

        service.setName(newServiceName);
        service.setPrice(newServicePrice);

        // Assert
        assertEquals(newServiceName, service.getName());
        assertEquals(newServicePrice, service.getPrice(), 0.01); // Using a delta for float comparison
    }

    @Test
    void testServiceToString() {
        // Arrange
        Service service = new Service("Test Service", 19.99f);

        // Act
        String toStringResult = service.toString();

        // Assert
        assertEquals("Test Service - $19.99", toStringResult);
    }
}
