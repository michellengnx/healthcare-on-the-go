package data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.CreateRequest.ApiAccessException;
import entities.factories.service_request.InvalidLocationException;

import static org.junit.jupiter.api.Assertions.*;

class ApiAccessObjectTest {
    private final String apiKey = System.getenv("API_KEY");
    private final ApiAccessObject apiAccessObject = new ApiAccessObject(apiKey);

    @Test
    void testGetEta() {
        try {
            assertEquals(60, apiAccessObject.getEta("University of Toronto", "York University"), 60);
        } catch (InvalidLocationException | ApiAccessException e) {
            fail("Successful API call expected");
        }
    }

    @Test
    void testGetEtaFail() {
        assertThrows(InvalidLocationException.class, () -> {apiAccessObject.getEta("NSIUFDsifuy9gyfq8", "York University");});
        assertThrows(ApiAccessException.class, () -> {(new ApiAccessObject("")).getEta("1", " 1");});
    }

    @Test
    void testGetDistance() {
        try {
            assertEquals(10.7, apiAccessObject.getDistance("University of Toronto", "York University"), 1);
        } catch (InvalidLocationException | ApiAccessException e) {
            fail("Successful API call expected");
        }
    }

    @Test
    void testGetDistanceFail() {
        assertThrows(InvalidLocationException.class, () -> {apiAccessObject.getDistance("NSIUFDsifuy9gyfq8", "York University");});
        assertThrows(ApiAccessException.class, () -> {(new ApiAccessObject("")).getDistance("1", " 1");});
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
    void testGetPriceFail() {
        assertThrows(InvalidLocationException.class, () -> {apiAccessObject.getPrice("NSIUFDsifuy9gyfq8", "York University");});
        assertThrows(ApiAccessException.class, () -> {(new ApiAccessObject("")).getPrice("1", " 1");});
    }

    @Test
    void testGetTrafficMap() {
        try {
            assertNotEquals("", apiAccessObject.getTrafficMap("University of Toronto", "York University"));
        } catch (InvalidLocationException | ApiAccessException e) {
            fail("Successful API call expected");
        }
    }

    @Test
    void testGetTrafficMapFail() {
        assertThrows(ApiAccessException.class, () -> {(new ApiAccessObject("")).getTrafficMap("1", " 1");});
    }
}