package entities.factories.service_request;

public interface TravelCostCalculator {
    /**
     * Return the price of a car ride from startLoc to endLoc by car.
     *
     * @param startLoc Address/name representing the starting location.
     * @param endLoc Address/name representing the end location.
     * @return The estimated price of a car ride from startLoc to endLoc by car.
     */
    public float getPrice(String startLoc, String endLoc) throws InvalidLocationException;
}
