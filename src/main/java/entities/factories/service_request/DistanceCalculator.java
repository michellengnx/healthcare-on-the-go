package entities.factories.service_request;

public interface DistanceCalculator {
    /**
     * Return the distance by car from startLoc to endLoc by car.
     *
     * @param startLoc Address/name representing the starting location.
     * @param endLoc Address/name representing the end location.
     * @return The distance by car from startLoc to endLoc by car.
     */
    public float getDistance(String startLoc, String endLoc) throws InvalidLocationException, DataUnavailableException;
}
