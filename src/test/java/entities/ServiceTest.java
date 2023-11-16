package entities;

import org.junit.jupiter.api.Test;

public class ServiceTest {

    @Test
    public void testServiceConstructor() {
        Service s = new Service("Annual checkup", 100);
        assert s.getName().equals("Annual checkup");
        assert s.getPrice() == 100;
    }
}
