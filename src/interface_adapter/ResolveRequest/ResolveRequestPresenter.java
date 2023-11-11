package interface_adapter.ResolveRequest;

import interface_adapter.ViewRequest.ViewRequestState;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.ResolveRequest.ResolveRequestOutputBoundary;
import use_case.ResolveRequest.ResolveRequestOutputData;

public class ResolveRequestPresenter implements ResolveRequestOutputBoundary {
    private final ViewRequestViewModel viewRequestViewModel;

    public ResolveRequestPresenter(ViewRequestViewModel viewRequestViewModel) {
        this.viewRequestViewModel = viewRequestViewModel;
    }

    @Override
    public void prepareSuccessView(ResolveRequestOutputData response) {
        // Create a new ViewRequestState whose response instance attribute is the resolved response
        ViewRequestState viewRequestState = this.viewRequestViewModel.getState();
        viewRequestState.setRequest(response.getRequest());

        // set the viewRequestModel's new state, alert the view of the changes
        this.viewRequestViewModel.setState(viewRequestState);
        this.viewRequestViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // Create a new CreateRequestState with the given error message
        ViewRequestState viewRequestState = this.viewRequestViewModel.getState();
        viewRequestState.setViewRequestError(error);

        // alert the view of the state change
        this.viewRequestViewModel.setState(viewRequestState);
        this.viewRequestViewModel.firePropertyChanged();
    }
}
