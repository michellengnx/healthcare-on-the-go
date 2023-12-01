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
        ArrayList<ArrayList<String>> data = requests.getData();
        for (ArrayList<String> row : data) {
            viewRequestViewModel.getViewRequestState().getUserName().add(row.get(0));
            viewRequestViewModel.getViewRequestState().getCreationTime().add(row.get(1));
            viewRequestViewModel.getViewRequestState().getDoctorNames().add(row.get(2));
            viewRequestViewModel.getViewRequestState().getUrgencies().add(Integer.parseInt(row.get(3)));
            viewRequestViewModel.getViewRequestState().getDestinations().add(row.get(4));
            viewRequestViewModel.getViewRequestState().getServices().add(row.get(5));
            viewRequestViewModel.getViewRequestState().getEtas().add(Float.parseFloat(row.get(7)));
            viewRequestViewModel.getViewRequestState().getDistances().add(Float.parseFloat(row.get(8)));
            viewRequestViewModel.getViewRequestState().getCompleted().add(Boolean.parseBoolean(row.get(9)));
        }
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
