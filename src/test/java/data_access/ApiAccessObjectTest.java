package data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.CreateRequest.ApiAccessException;
import entities.factories.service_request.InvalidLocationException;

import static org.junit.jupiter.api.Assertions.*;

class ApiAccessObjectTest {
    private final String apiKey = System.getenv("API_KEY");;
    private final ApiAccessObject apiAccessObject = new ApiAccessObject(apiKey);

    @Test
    void testGetEta() {
        if (apiKey == null) {
            return;
        } else {
            try {
                assertEquals(60, apiAccessObject.getEta("University of Toronto", "York University"), 60);
            } catch (InvalidLocationException | ApiAccessException e) {
                fail("Successful API call expected");
            }
        }
    }

    @Test
    void testGetEtaFail() {
        if (this.apiKey.equals("")) {
            return;
        } else {
            assertThrows(InvalidLocationException.class, () -> {apiAccessObject.getEta("NSIUFDsifuy9gyfq8", "York University");});
            assertThrows(ApiAccessException.class, () -> {(new ApiAccessObject("")).getEta("1", " 1");});
        }
    }

    @Test
    void testGetDistance() {
        if (this.apiKey.equals("")) {
            return;
        } else {
            try {
                assertEquals(8.7, apiAccessObject.getDistance("University of Toronto", "York University"), 1);
            } catch (InvalidLocationException | ApiAccessException e) {
                fail("Successful API call expected");
            }
        }
    }

    @Test
    void testGetDistanceFail() {
        if (this.apiKey.equals("")) {
            return;
        } else {
            assertThrows(InvalidLocationException.class, () -> {apiAccessObject.getDistance("NSIUFDsifuy9gyfq8", "York University");});
            assertThrows(ApiAccessException.class, () -> {(new ApiAccessObject("")).getDistance("1", " 1");});
        }
    }

    @Test
    void testGetPrice() {
        if (this.apiKey.equals("")) {
            return;
        } else {
            try {
                assertEquals(60, apiAccessObject.getPrice("University of Toronto", "York University"), 60);
            } catch (InvalidLocationException | ApiAccessException e) {
                fail("Successful API call expected");
            }
        }
    }

    @Test
    void testGetPriceFail() {
        if (this.apiKey.equals("")) {
            return;
        } else {
            assertThrows(InvalidLocationException.class, () -> {apiAccessObject.getPrice("NSIUFDsifuy9gyfq8", "York University");});
            assertThrows(ApiAccessException.class, () -> {(new ApiAccessObject("")).getPrice("1", " 1");});
        }
    }

    @Test
    void testGetTrafficMap() {
        if (this.apiKey.equals("")) {
            return;
        } else {
            try {
                assertNotEquals("", apiAccessObject.getTrafficMap("University of Toronto", "York University"));
            } catch (InvalidLocationException | ApiAccessException e) {
                fail("Successful API call expected");
            }
        }
    }

    @Test
    void testGetTrafficMapFail() {
        if (this.apiKey.equals("")) {
            return;
        } else {
            assertThrows(ApiAccessException.class, () -> {(new ApiAccessObject("")).getTrafficMap("1", " 1");});
        }
    }
}