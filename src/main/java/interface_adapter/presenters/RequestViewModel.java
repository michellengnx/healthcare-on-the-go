package interface_adapter.presenters;

import entities.Service;
import entities.ServiceRequest;

import java.util.ArrayList;

public class RequestViewModel {
    private ArrayList<String> userName;
    private ArrayList<String> doctorNames;
    private ArrayList<String> services;
    private ArrayList<String> destinations;
    private ArrayList<Integer> urgencys;
    private ArrayList<Float> etas;
    private ArrayList<Float> distances;
    private ArrayList<Boolean> completed;

    public RequestViewModel(ArrayList<ServiceRequest> requests) {
        this.userName = new ArrayList<String>();
        this.doctorNames = new ArrayList<String>();
        this.services = new ArrayList<String>();
        this.destinations = new ArrayList<String>();
        this.urgencys = new ArrayList<Integer>();
        this.etas = new ArrayList<Float>();
        this.distances = new ArrayList<Float>();
        this.completed = new ArrayList<Boolean>();


        for ( ServiceRequest request: requests){
            this.userName.add(request.getPatient().getUsername());
            this.doctorNames.add(request.getDoctor().getUsername());
            this.services.add(request.getService().getName())
            this.destinations.add(request.getDestination());
            this.urgencys.add(request.getUrgencyLevel());;
            this.etas.add(request.getEta());
            this.distances.add(request.getDistance());
            this.completed.add(request.isCompleted());;

        }
    }

    }
