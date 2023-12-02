package interface_adapter.ViewRequest;

import interface_adapter.SignUp.SignUpPresenter;
import interface_adapter.ViewManagerModel;
import use_case.SignUp.SignUpOutputData;
import use_case.ViewRequest.ViewRequestInteractor;
import use_case.ViewRequest.ViewRequestOutputBoundary;
import use_case.ViewRequest.ViewRequestOutputData;

import java.util.ArrayList;

public class ViewRequestPresenter implements ViewRequestOutputBoundary {
    private final ViewRequestViewModel viewRequestViewModel;
    private ViewManagerModel viewManagerModel;

    public ViewRequestPresenter(ViewManagerModel viewManagerModel, ViewRequestViewModel viewRequestViewModel){
        this.viewRequestViewModel = viewRequestViewModel;
        this.viewManagerModel = viewManagerModel;

    }


    /**
     * @param requests
     */
    @Override
    public void prepareSuccessView(ViewRequestOutputData requests) {
        ViewRequestState currentState = viewRequestViewModel.getState();

        ArrayList<ArrayList<String>> data = requests.getData();
        for (ArrayList<String> row : data) {
            currentState.getUserName().add(row.get(0));
            currentState.getCreationTime().add(row.get(1));
            currentState.getDoctorNames().add(row.get(2));
            currentState.getUrgencies().add(Integer.parseInt(row.get(3)));
            currentState.getDestinations().add(row.get(4));
            currentState.getServices().add(row.get(5));
            currentState.getEtas().add(Float.parseFloat(row.get(7)));
            currentState.getDistances().add(Float.parseFloat(row.get(8)));
            currentState.getCompleted().add(Boolean.parseBoolean(row.get(9)));
        }

        this.viewRequestViewModel.setState(currentState);
        this.viewRequestViewModel.firePropertyChanged();


        this.viewManagerModel.setActiveView(viewRequestViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    /**
     * @param error
     */
    @Override
    public void prepareFailView(String error) {


    }
}
