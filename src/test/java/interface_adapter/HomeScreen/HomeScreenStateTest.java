package interface_adapter.HomeScreen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HomeScreenStateTest {

    private HomeScreenState homeScreenState;

    @BeforeEach
    public void setUp() {
        // Set up common state for tests
        homeScreenState = new HomeScreenState();
        homeScreenState.setPatient("John Doe");
        homeScreenState.setActiveRequest(true);
        homeScreenState.setImageUrl("/images/profile.jpg");
    }

    @Test
    public void testDefaultConstructor() {
        // Create a HomeScreenState object using the default constructor
        HomeScreenState defaultState = new HomeScreenState();

        // Check if the values are initialized correctly
        assertNull(defaultState.getPatient());
        assertFalse(defaultState.isActiveRequest());
        assertNull(defaultState.getImageUrl());
    }

    @Test
    public void testGetters() {
        // Check if the values are retrieved correctly using getters
        assertEquals("John Doe", homeScreenState.getPatient());
        assertTrue(homeScreenState.isActiveRequest());
        assertEquals("/images/profile.jpg", homeScreenState.getImageUrl());
    }

    @Test
    public void testSetters() {
        // Change values using setters
        homeScreenState.setPatient("Jane Doe");
        homeScreenState.setActiveRequest(false);
        homeScreenState.setImageUrl("/images/new_profile.jpg");

        // Check if the values are set correctly
        assertEquals("Jane Doe", homeScreenState.getPatient());
        assertFalse(homeScreenState.isActiveRequest());
        assertEquals("/images/new_profile.jpg", homeScreenState.getImageUrl());
    }
}
