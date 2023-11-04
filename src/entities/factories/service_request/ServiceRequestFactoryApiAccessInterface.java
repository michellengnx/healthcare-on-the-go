package entities.factories.service_request;

public interface ServiceRequestFactoryApiAccessInterface {
    public float getDistance(String startLoc, String endLoc);
    public float getEta(String startLoc, String endLoc);
    public float getPrice(String startLoc, String endLoc);
}
