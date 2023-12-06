package interface_adapter.Loggedin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggedinStateTest {

    private LoggedinState loggedinState;

    @BeforeEach
    void setUp() {
        loggedinState = new LoggedinState();
    }

    @Test
    void getUsername() {
        loggedinState.setUsername("testUser");
        assertEquals("testUser", loggedinState.getUsername());
    }

    @Test
    void copyConstructor() {
        LoggedinState original = new LoggedinState();
        original.setUsername("testUser");

        LoggedinState copy = new LoggedinState(original);

        assertEquals(original.getUsername(), copy.getUsername());
    }
}
