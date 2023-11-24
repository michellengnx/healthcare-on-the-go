package data_access;

import entities.Service;
import entities.ServiceRequest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class FileRequestDataAccessObject implements RequestDataAccess {
    private static final String REQUESTS_CSV_FILE = "/Users/ismaelchona/IdeaProject/csc207-project/src/main/java/data/requests.csv";
    @Override
    public ArrayList<ServiceRequest> getRequestUser(String userName) {
        // Logic to retrieve a request from storage (e.g., CSV file)
        return new ArrayList<>();// Placeholder return
    }

    @Override
    public void addRequest(ServiceRequest request) {
        try (FileWriter writer = new FileWriter(REQUESTS_CSV_FILE, true)) {
            writer.append(formatServiceRequestToCsv(request));
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  String formatServiceRequestToCsv(ServiceRequest request) {
        // Logic to convert ServiceRequest object to CSV format
        // Return a string representing ServiceRequest in CSV format
        return String.format("%s,%s,%s,%d,%s,%s,%.2f,%.2f,%.2f,%s",
                request.getPatient().getUsername(),
                request.getCreationTime().toString(),
                request.getDoctor().getUsername(), // Assuming Doctor has an ID field
                request.getUrgencyLevel(),
                request.getDestination(),
                request.getService().getName(), // Assuming Service has a name field
                request.getPrice(),
                request.getEta(),
                request.getDistance(),
                Boolean.toString(request.isCompleted()));
    }

}