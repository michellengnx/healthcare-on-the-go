package interface_adapter.ViewRequest;

import entities.ServiceRequest;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;



public class ViewRequestViewModel extends ViewModel {
    public ViewRequestState getViewRequestState() {
        return viewRequestState;
    }

    public void setViewRequestState(ViewRequestState viewRequestState) {
        this.viewRequestState = viewRequestState;
    }

    private ViewRequestState viewRequestState = new ViewRequestState();

    public ViewRequestViewModel() {
        super("view requests");


    }

    public ViewRequestState getState() {
        return this.viewRequestState;
    }

    public void setState(ViewRequestState newState) {
        this.viewRequestState = newState;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }



}