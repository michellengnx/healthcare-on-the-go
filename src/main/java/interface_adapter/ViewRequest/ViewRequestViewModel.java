package interface_adapter.ViewRequest;

import entities.ServiceRequest;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

// TODO : IMPLEMENT

public class ViewRequestViewModel extends ViewModel {
    private ArrayList<String> userName;

    private ArrayList<String> creationTime

    private ArrayList<String> doctorNames;
    private ArrayList<String> services;
    private ArrayList<String> destinations;

    private ArrayList<Integer> urgencys;
    private ArrayList<Float> etas;
    private ArrayList<Float> distances;
    private ArrayList<Boolean> completed;

    public ViewRequestViewModel(ArrayList<ArrayList<String>> requests) {
        super("view request");
        this.userName = new ArrayList<String>();
        this.doctorNames = new ArrayList<String>();
        this.creationTime = new ArrayList<String>();
        this.services = new ArrayList<String>();
        this.destinations = new ArrayList<String>();
        this.urgencys = new ArrayList<Integer>();
        this.etas = new ArrayList<Float>();
        this.distances = new ArrayList<Float>();
        this.completed = new ArrayList<Boolean>();

// headers.put("patient", 0);
//        headers.put("creation_time", 1);
//        headers.put("doctor", 2);
//        headers.put("urgency_level", 3);
//        headers.put("destination", 4);
//        headers.put("service", 5);
//        headers.put("price", 6);
//        headers.put("eta", 7);
//        headers.put("distance", 8);

        for (ArrayList<String> request : requests) {
            this.userName.add(request.get(0));
            this.creationTime.add(request.get(1));
            this.doctorNames.add(request.get(2));
            this.services.add(request.get(5));
            this.destinations.add(request.get(4));
            this.urgencys.add(Integer.parseInt(request.get(3)));
            this.etas.add(Float.parseFloat(request.get(7)));
            this.distances.add(Float.parseFloat(request.get(8)));
            this.completed.add(request);

        }
    }



    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public ViewRequestState getState() {
        return new ViewRequestState();
    }

    public void setState(ViewRequestState viewRequestState) {
    }
}