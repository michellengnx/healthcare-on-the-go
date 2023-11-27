package entities.factories.service_request;

public interface EtaCalculator {
    /**
     * Return the estimated time or arrival from startLoc to endLoc by car.
     *
     * @param startLoc Address/name representing the starting location.
     * @param endLoc Address/name representing the end location.
     * @return The estimated time or arrival from startLoc to endLoc by car.
     */
    public float getEta(String startLoc, String endLoc) throws InvalidLocationException;
}
