package use_case.CreateRequest;

import entities.factories.service_request.*;

/**
 * Methods that an API access object must implement for the create request interactor to function properly.
 */
public interface CreateRequestApiAccessInterface extends TravelCostCalculator, DistanceCalculator, EtaCalculator {
    /**
     * Return the distance by car from startLoc to endLoc by car in km.
     *
     * @param startLoc Address/name representing the starting location.
     * @param endLoc Address/name representing the end location.
     * @return The distance by car from startLoc to endLoc by car.
     */
    public float getDistance(String startLoc, String endLoc) throws InvalidLocationException, ApiAccessException;

    /**
     * Return the estimated time or arrival from startLoc to endLoc by car in minutes.
     *
     * @param startLoc Address/name representing the starting location.
     * @param endLoc Address/name representing the end location.
     * @return The estimated time or arrival from startLoc to endLoc by car.
     */
    public float getEta(String startLoc, String endLoc) throws InvalidLocationException, ApiAccessException;

    /**
     * Return the price of a car ride from startLoc to endLoc by car in minutes.
     *
     * @param startLoc Address/name representing the starting location.
     * @param endLoc Address/name representing the end location.
     * @return The estimated price of a car ride from startLoc to endLoc by car.
     */
    public float getPrice(String startLoc, String endLoc) throws InvalidLocationException, ApiAccessException;

    /**
     * Return a URL or a map of a car ride from startLoc to endLoc by car..
     *
     * @param startLoc Address/name representing the starting location.
     * @param endLoc Address/name representing the end location.
     * @return The URL of a traffic map from startLoc to endLoc by car.
     */
    public String getTrafficMap(String startLoc, String endLoc) throws InvalidLocationException, ApiAccessException;
}
