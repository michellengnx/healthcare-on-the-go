package data_access;

import entities.ServiceRequest;

import java.util.ArrayList;

public interface RequestDataAccess {
    ArrayList<ServiceRequest> getRequestUser(String userName);
    void addRequest(ServiceRequest request);
}
