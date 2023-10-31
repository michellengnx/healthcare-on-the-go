import entities.Doctor;
import entities.Review;
import entities.Service;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ReviewTests {
    @Test
    public void testReview(){
        Date date = new Date();
        String review_text = "review";
        int stars = 4;
        int id = 13;
        List<String> list = new ArrayList<>(List.of("General care"));
        List<Service> list2 = new ArrayList<>(List.of(new Service("Oncology", 2)));
        Doctor doctor = new Doctor("username", "password", "email", "phone number", "gender", new Date(), id, "Toronto general", list, list2);

        Review review = new Review("review", date, stars,doctor);
        assert stars == review.getStars();
        assert stars == review.getStars();
        assert review_text.equals(review.getReview());
        assert date == review.getTime();
        assert doctor == review.getDoctor();


        
    }

}