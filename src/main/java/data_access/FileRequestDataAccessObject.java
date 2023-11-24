package data_access;

import entities.Service;
import entities.ServiceRequest;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FileRequestDataAccessObject implements RequestDataAccess {
    @Override
    public ArrayList<ServiceRequest> getRequestUser(String userName) {
        // Logic to retrieve a request from storage (e.g., CSV file)
        return new ArrayList<>();// Placeholder return
    }
}