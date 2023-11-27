package entities.matchers;

import entities.Doctor;
import entities.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.CreateRequest.NoAvailableDoctorException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DoctorMatcherTest {
    private final Service xRay = new Service("X-Ray", 200);
    private final Service checkUp = new Service("Check Up", 75);
    private final Service nutritionalServices = new Service("Nutritional Services", 100);
    private Doctor xRaySpecialist;
    private Doctor checkUpSpecialist;
    private Doctor nutritionalServicesSpecialist;

    @BeforeEach
    void init(){
        List<Service> xRayList = new ArrayList<>();
        List<Service> checkUpList = new ArrayList<>();
        List<Service> nutritionalServicesList = new ArrayList<>();

        xRayList.add(xRay);
        checkUpList.add(checkUp);
        nutritionalServicesList.add(nutritionalServices);

        xRaySpecialist = new Doctor(
                "xrayDoc",
                "pass1",
                "mail1@mail.com",
                "123-123-1231",
                "male",
                new Date(),
                1,
                "23 Road Lane",
                new ArrayList<>(),
                xRayList);
        checkUpSpecialist = new Doctor(
                "checkupDoc",
                "pass1",
                "mail2@mail.com",
                "123-123-1231",
                "male",
                new Date(),
                2,
                "23 Road Lane",
                new ArrayList<>(),
                checkUpList);
        nutritionalServicesSpecialist = new Doctor(
                "nutriDoc",
                "pass1",
                "mail3@mail.com",
                "123-123-1231",
                "male",
                new Date(),
                3,
                "23 Road Lane",
                new ArrayList<>(),
                nutritionalServicesList);
    }

    /**
     * Ensure the closest doctor is returned when no specialized doctors are available.
     */
    @Test
    void noSpecializedDoctorTest() {
        Map<Doctor, Float> doctorEta = new HashMap<>();
        doctorEta.put(nutritionalServicesSpecialist, 30f);
        doctorEta.put(checkUpSpecialist, 40f);

        DoctorMatcher matcher = new DoctorMatcher(xRay, new LowestEtaDoctorStrategy(doctorEta));

        try {
            Doctor matchedDoctor = matcher.match();
            assertEquals("nutriDoc", matchedDoctor.getUsername());
        } catch (NoAvailableDoctorException e) {
            fail("Failure not expected");
        }
    }

    /**
     * Ensure the specialized doctor is returned when they are less than 60 minutes away.
     */
    @Test
    void hasSpecializedDoctorTest() {
        Map<Doctor, Float> doctorEta = new HashMap<>();
        doctorEta.put(xRaySpecialist, 50f);
        doctorEta.put(nutritionalServicesSpecialist, 30f);
        doctorEta.put(checkUpSpecialist, 40f);

        DoctorMatcher matcher = new DoctorMatcher(xRay, new LowestEtaDoctorStrategy(doctorEta));

        try {
            Doctor matchedDoctor = matcher.match();
            assertEquals("xrayDoc", matchedDoctor.getUsername());
        } catch (NoAvailableDoctorException e) {
            fail("Failure not expected");
        }
    }

    /**
     * Ensure the closest doctor is returned when the specialized doctor is an hour or more away.
     */
    @Test
    void specializedDoctorTooFarTest() {
        Map<Doctor, Float> doctorEta = new HashMap<>();
        doctorEta.put(xRaySpecialist, 60f);
        doctorEta.put(nutritionalServicesSpecialist, 30f);
        doctorEta.put(checkUpSpecialist, 40f);

        DoctorMatcher matcher = new DoctorMatcher(xRay, new LowestEtaDoctorStrategy(doctorEta));

        try {
            Doctor matchedDoctor = matcher.match();
            assertEquals("nutriDoc", matchedDoctor.getUsername());
        } catch (NoAvailableDoctorException e) {
            fail("Failure not expected");
        }
    }

    /**
     * Ensure an exception is raised when no doctors are available.
     */
    @Test
    void failTest() {
        Map<Doctor, Float> doctorEta = new HashMap<>();

        DoctorMatcher matcher = new DoctorMatcher(xRay, new LowestEtaDoctorStrategy(doctorEta));

        try {
            matcher.match();
            fail("Success not expected");
        } catch (NoAvailableDoctorException e) {
            return;
        }
    }
}