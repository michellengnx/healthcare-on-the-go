package view;

import interface_adapter.ViewRequest.RequestController;
import interface_adapter.ViewRequest.ViewRequestViewModel;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.util.ArrayList;

public class ViewRequestsView extends JFrame{
    private final String viewName = "Request History";
    private final ViewRequestViewModel viewRequestViewModel;
    private final RequestController requestController;

    public ViewRequestsView(ViewRequestViewModel viewRequestViewModel, RequestController requestController){
        this.requestController = requestController;
        this.viewRequestViewModel = viewRequestViewModel;

        JLabel title = new JLabel("Request History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<String> userName = viewRequestViewModel.getUserName();
        ArrayList<String> doctorNames = viewRequestViewModel.getDoctorNames();
        ArrayList<String> creationTime = viewRequestViewModel.getDoctorNames();
        ArrayList<String> services = viewRequestViewModel.getServices();
        ArrayList<String> destinations = viewRequestViewModel.getDestinations();
        ArrayList<Integer> urgencies = viewRequestViewModel.getUrgencys();
        ArrayList<Float> etas = viewRequestViewModel.getEtas();
        ArrayList<Float> distances = viewRequestViewModel.getDistances();
        ArrayList<Boolean> completed = viewRequestViewModel.getCompleted();



    }





}
