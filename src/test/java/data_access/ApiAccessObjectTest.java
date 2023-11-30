package data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.CreateRequest.ApiAccessException;
import use_case.CreateRequest.InvalidLocationException;

import static org.junit.jupiter.api.Assertions.*;

class ApiAccessObjectTest {
    private ApiAccessObject apiAccessObject = new ApiAccessObject("");

    @Test
    void testGetEta() {
        try {
            assertEquals(60, apiAccessObject.getEta("University of Toronto", "York University"), 60);
        } catch (InvalidLocationException | ApiAccessException e) {
            fail("Successful API call expected");
        }
    }

    @Test
    void testGetDistance() {
        try {
            assertEquals(87, apiAccessObject.getDistance("University of Toronto", "York University"), 1);
        } catch (InvalidLocationException | ApiAccessException e) {
            fail("Successful API call expected");
        }
    }

    @Test
    void testGetPrice() {
        try {
            assertEquals(60, apiAccessObject.getPrice("University of Toronto", "York University"), 60);
        } catch (InvalidLocationException | ApiAccessException e) {
            fail("Successful API call expected");
        }
    }

    @Test
    void testGetTrafficMap() {
        try {
            assertNotEquals("", apiAccessObject.getTrafficMap("University of Toronto", "York University"));
        } catch (InvalidLocationException | ApiAccessException e) {
            fail("Successful API call expected");
        }
    }
}