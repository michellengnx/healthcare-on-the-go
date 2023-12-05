package use_case.ViewRequest;

import entities.ServiceRequest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface defining methods for accessing and managing service requests.
 */
public interface RequestDataAccess {
    ArrayList<ArrayList<String>> getRequestUser(String userName);

    void addRequest(ServiceRequest request, String userName);

    void clear();
}
