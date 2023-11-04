package use_case.CreateRequest;

public interface CreateRequestApiAccessInterface {
    public float getDistance(String startLoc, String endLoc);
    public float getEta(String startLoc, String endLoc);
    public float getPrice(String startLoc, String endLoc);
}
