package use_case.SignUp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignUpOutputDataTest {

    @Test
    void testSignUpOutputDataCreation() {
        // Arrange
        String username = "testUser";
        String creationTime = "2023-01-01T12:00:00"; // Replace with an actual timestamp
        boolean useCaseFailed = false;

        // Act
        SignUpOutputData signUpOutputData = new SignUpOutputData(username, creationTime, useCaseFailed);

        // Assert
        assertNotNull(signUpOutputData, "SignUpOutputData should not be null");
        assertEquals(username, signUpOutputData.getUsername(), "Username should match");
        assertEquals(creationTime, signUpOutputData.getCreationTime(), "CreationTime should match");
        assertFalse(signUpOutputData.getUseCaseFailed(), "UseCaseFailed should be false");

        // Update creationTime using the setter
        String updatedCreationTime = "2023-01-02T12:00:00"; // Replace with an actual timestamp
        signUpOutputData.setCreationTime(updatedCreationTime);
        assertEquals(updatedCreationTime, signUpOutputData.getCreationTime(), "Updated CreationTime should match");
    }

    @Test
    void testSignUpOutputDataUseCaseFailed() {
        // Arrange
        SignUpOutputData signUpOutputData = new SignUpOutputData("testUser", "2023-01-01T12:00:00", true);

        // Assert
        assertTrue(signUpOutputData.getUseCaseFailed(), "UseCaseFailed should be true");
    }
}
