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
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> creationTimes = new ArrayList<>();
        ArrayList<String> doctorNames = new ArrayList<>();
        ArrayList<Integer> urgencies = new ArrayList<>();
        ArrayList<String> destinations = new ArrayList<>();
        ArrayList<String> services = new ArrayList<>();
        ArrayList<Float> etas = new ArrayList<>();
        ArrayList<Float> distances = new ArrayList<>();
        ArrayList<Boolean> completed = new ArrayList<>();

        for (ArrayList<String> row : data) {
            usernames.add(row.get(0));
            creationTimes.add(row.get(1));
            doctorNames.add(row.get(2));
            urgencies.add(Integer.parseInt(row.get(3)));
            destinations.add(row.get(4));
            services.add(row.get(5));
            etas.add(Float.parseFloat(row.get(7)));
            distances.add(Float.parseFloat(row.get(8)));
            completed.add(Boolean.parseBoolean(row.get(9)));
        }

        currentState.setUserName(usernames);
        currentState.setCreationTime(creationTimes);
        currentState.setDoctorNames(doctorNames);
        currentState.setUrgencies(urgencies);
        currentState.setDestinations(destinations);
        currentState.setServices(services);
        currentState.setEtas(etas);
        currentState.setDistances(distances);
        currentState.setCompleted(completed);

        this.viewRequestViewModel.setState(currentState);
        this.viewRequestViewModel.firePropertyChanged();

        System.out.println("viewing test 123");
        System.out.println(currentState.getUserName());

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
