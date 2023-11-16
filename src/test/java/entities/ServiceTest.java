package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ServiceTest {

    @Test
    public void testServiceConstructor() {
        Service s = new Service("Annual checkup", 100);
        assertEquals("Annual checkup", s.getName());
        assertEquals(100, s.getPrice());
    }
}
