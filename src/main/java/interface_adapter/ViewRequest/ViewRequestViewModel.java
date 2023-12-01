package interface_adapter.ViewRequest;

import entities.ServiceRequest;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;



public class ViewRequestViewModel extends ViewModel {
    private ArrayList<String> userName;

    private ArrayList<String> creationTime;

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


        for (ArrayList<String> request : requests) {
            this.userName.add(request.get(0));
            this.creationTime.add(request.get(1));
            this.doctorNames.add(request.get(2));
            this.services.add(request.get(5));
            this.destinations.add(request.get(4));
            this.urgencys.add(Integer.parseInt(request.get(3)));
            this.etas.add(Float.parseFloat(request.get(7)));
            this.distances.add(Float.parseFloat(request.get(8)));
            // read the completed column to get true or false.
            if (requests.get(9).equals("true"))
            {
                this.completed.add(true);
            }
            else{
                this.completed.add(false);
            }
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