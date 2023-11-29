package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReviewTest {

    private Review review;
    private Doctor doctor;

    @BeforeEach
    public void setUp() {
        doctor = new Doctor("username", "password", "email@example.com",
                "123-456-7890", "Male", new Date(), 1, "Hospital", null, null);
        review = new Review("Good experience", new Date(), 4, doctor);
    }

    @Test
    public void testReviewInitialization() {
        assertEquals("Good experience", review.getReview(), "Review should match the initialized value");
        assertEquals(4, review.getStars(), "Stars should match the initialized value");
        assertEquals(doctor, review.getDoctor(), "Doctor should match the initialized value");
    }

    @Test
    public void testSetReview() {
        review.setReview("Excellent service");
        assertEquals("Excellent service", review.getReview(), "Review should be updated");
    }

    @Test
    public void testSetStars() {
        review.setStars(5);
        assertEquals(5, review.getStars(), "Stars should be updated");
    }

    @Test
    public void testSetTime() {
        Date newTime = new Date();
        review.setTime(newTime);
        assertEquals(newTime, review.getTime(), "Time should be updated");
    }

    @Test
    public void testSetDoctor() {
        Doctor newDoctor = new Doctor("newUsername", "newPassword", "newEmail@example.com",
                "111-222-3333", "Female", new Date(), 2, "Clinic", null, null);
        review.setDoctor(newDoctor);
        assertEquals(newDoctor, review.getDoctor(), "Doctor should be updated");
    }

}
