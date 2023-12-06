package interface_adapter.ViewRequest;

import java.util.ArrayList;

/**
 * Represents the state of view-specific data for handling view-related information
 * in the context of viewing request details.
 */
public class ViewRequestState {
    private ArrayList<String> userName = new ArrayList<>();
    private ArrayList<String> creationTime = new ArrayList<>();
    private ArrayList<String> doctorNames = new ArrayList<>();
    private ArrayList<String> services = new ArrayList<>();
    private ArrayList<String> destinations = new ArrayList<>();
    private ArrayList<Integer> urgencies = new ArrayList<>();

    public ArrayList<String> getUserName() {
        return userName;
    }

    public void setUserName(ArrayList<String> userName) {
        this.userName = userName;
    }

    public ArrayList<String> getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(ArrayList<String> creationTime) {
        this.creationTime = creationTime;
    }

    public ArrayList<String> getDoctorNames() {
        return doctorNames;
    }

    public void setDoctorNames(ArrayList<String> doctorNames) {
        this.doctorNames = doctorNames;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }

    public ArrayList<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList<String> destinations) {
        this.destinations = destinations;
    }

    public ArrayList<Integer> getUrgencies() {
        return urgencies;
    }

    public void setUrgencies(ArrayList<Integer> urgencies) {
        this.urgencies = urgencies;
    }

    public ArrayList<Float> getEtas() {
        return etas;
    }

    public void setEtas(ArrayList<Float> etas) {
        this.etas = etas;
    }

    public ArrayList<Boolean> getCompleted() {
        return completed;
    }

    public void setCompleted(ArrayList<Boolean> completed) {
        this.completed = completed;
    }

    private ArrayList<Float> etas = new ArrayList<>();

    public ArrayList<Float> getDistances() {
        return distances;
    }

    public void setDistances(ArrayList<Float> distances) {
        this.distances = distances;
    }

    private ArrayList<Float> distances = new ArrayList<>();
    private ArrayList<Boolean> completed = new ArrayList<>();

    /**
     * Copy constructor to create a new instance by copying another instance of ViewRequestState.
     *
     * @param copy The ViewRequestState object to copy.
     */
    public ViewRequestState(ViewRequestState copy) {
        this.userName.addAll(copy.userName);
        this.creationTime.addAll(copy.creationTime);
        this.doctorNames.addAll(copy.doctorNames);
        this.services.addAll(copy.services);
        this.destinations.addAll(copy.destinations);
        this.urgencies.addAll(copy.urgencies);
        this.etas.addAll(copy.etas);
        this.distances.addAll(copy.distances);
        this.completed.addAll(copy.completed);
    }

    /**
     * Constructor to initialize ViewRequestState from an ArrayList of request data.
     *
     * @param requestData The ArrayList containing request details to initialize the state.
     */
    public ViewRequestState(ArrayList<ArrayList<String>> requestData) {
        for (ArrayList<String> request : requestData) {
            this.userName.add(request.get(0));
            this.creationTime.add(request.get(1));
            this.doctorNames.add(request.get(2));
            this.services.add(request.get(5));
            this.destinations.add(request.get(4));
            this.urgencies.add(Integer.parseInt(request.get(3)));
            this.etas.add(Float.parseFloat(request.get(7)));
            this.distances.add(Float.parseFloat(request.get(8)));
            this.completed.add(Boolean.parseBoolean(request.get(9)));
        }
    }

    // Default constructor
    public ViewRequestState() {}

}
