package use_case.ViewRequest;

import entities.ServiceRequest;

import java.util.ArrayList;

/**
 * Interface defining methods for accessing and managing service requests.
 */
public interface RequestDataAccessInterface {
    ArrayList<ArrayList<String>> getRequestUser(String userName);

    void addRequest(ServiceRequest request, String userName);

    void clear();
}
