package interface_adapter.CreateRequest;

import interface_adapter.ViewManagerModel;
import use_case.CreateRequest.CreateRequestOutputBoundary;
import use_case.CreateRequest.CreateRequestOutputData;

public class CreateRequestPresenter implements CreateRequestOutputBoundary {
    private final CreateRequestViewModel createRequestViewModel;
    private ViewRequestViewModel viewRequestViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateRequestPresenter(ViewManagerModel viewManagerModel,
                                  CreateRequestViewModel createRequestViewModel,
                                  ViewRequestViewModel viewRequestViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createRequestViewModel = createRequestViewModel;
        this.viewRequestViewModel = viewRequestViewModel;
    }
    @Override
    public void prepareSuccessView(CreateRequestOutputData response) {
        ViewRequestState viewRequestState = this.viewRequestViewModel.getState();

        viewRequestState.setRequest(response.getRequest());

        this.viewRequestViewModel.setState(viewRequestState);
        viewRequestViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(viewRequestViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CreateRequestState createRequestState = createRequestViewModel.getState();
        createRequestState.setCreateRequestError(error);
        createRequestViewModel.firePropertyChanged();
    }
}
