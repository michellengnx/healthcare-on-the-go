package data_access;

import entities.ServiceRequest;
import entities.ServiceRequestFactory;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

//User patient, Date creationTime, Doctor doctor, int urgencyLevel, String destination, Service service, float price, float eta, float distance)
public class FileRequestDataAccessObject implements RequestDataAccess {




    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<Integer, ArrayList<String>> requests = new HashMap<>();
    private final File csvFile;

    public FileRequestDataAccessObject(String csvPath, ServiceRequestFactory requestFactory) throws IOException {
        csvFile = new File(csvPath);
        headers.put("patient", 0);
        headers.put("creation_time", 1);
        headers.put("doctor", 2);
        headers.put("urgency_level", 3);
        headers.put("destination", 4);
        headers.put("service", 5);
        headers.put("price", 6);
        headers.put("eta", 7);
        headers.put("distance", 8);
        headers.put("isComplete,", 9);
        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("patient,creation_time,doctor,urgency_level,destination,service,price,eta,distance,isComplete");
                String row;
                int id = 0;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                    String doctor = String.valueOf(col[headers.get("doctor")]);
                    String urgencyLevel = String.valueOf(col[headers.get("urgency_level")]);
                    String destination = String.valueOf(col[headers.get("destination")]);
                    String service = String.valueOf(col[headers.get("service")]);
                    String price = String.valueOf(col[headers.get("price")]);
                    String eta = String.valueOf(col[headers.get("eta")]);
                    String patient = String.valueOf(col[headers.get("patient")]);
                    String distance = String.valueOf(col[headers.get("distance")]);
                    String isComplete = String.valueOf(col[headers.get("isComplete")]);

                    ArrayList<String> list = new ArrayList<>();
                    list.add(0, patient);
                    list.add(1, creationTimeText);
                    list.add(2, doctor);
                    list.add(3, urgencyLevel);
                    list.add(4, destination);
                    list.add(5, service);
                    list.add(6, price);
                    list.add(7, eta);
                    list.add(8, distance);
                    list.add(9,isComplete);
                    requests.put(id, list);
                    id++;
                }
            }
        }
    }

    @Override
    public ArrayList<ArrayList<String>> getRequestUser(String userName) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        // this line filter through array list to get this done
        Map<Integer, ArrayList<String>> filtered = requests.entrySet()
                .stream()
                .filter(map -> map.getValue().get(0).equals(userName))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        for (Map.Entry<Integer, ArrayList<String>> entry : requests.entrySet()) {

            result.add(entry.getKey(), entry.getValue());
        }
        return result;
    }
    @Override
    public void addRequest(ServiceRequest request){

        ArrayList<String> list = new ArrayList<>();
        list.add(0, request.getPatient().getUsername());
        list.add(1, request.getCreationTime().toString());
        list.add(2, request.getDoctor().getUsername());
        list.add(3, Integer.toString(request.getUrgencyLevel()));
        list.add(4, request.getDestination());
        list.add(5, request.getService().getName());
        list.add(6, Float.toString(request.getPrice()));
        list.add(7, Float.toString(request.getEta()));
        list.add(8, Float.toString(request.getDistance()));

        // Store a string 'true' if  its completes and "false" if it's not complete
        if (request.isCompleted()){
            list.add(9,"true");
        }
        else{
            list.add(9,"false");
        }
        requests.put(requests.size(), list);
        this.save();
    }



    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();
            for (ArrayList<String> request : requests.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        request.get(0), request.get(1), request.get(2), request.get(3), request.get(4), request.get(5), request.get(6), request.get(7), request.get(8), request.get(9));
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}






