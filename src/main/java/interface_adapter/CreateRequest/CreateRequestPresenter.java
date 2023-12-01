package interface_adapter.CreateRequest;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.CreateRequest.CreateRequestOutputBoundary;
import use_case.CreateRequest.CreateRequestOutputData;

/**
 * Presenter responsible for displaying the details of a successful request, or showing the appropriate error message.
 */
public class CreateRequestPresenter implements CreateRequestOutputBoundary {
    private final CreateRequestViewModel createRequestViewModel;
    private final ViewRequestViewModel viewRequestViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Create a CreateRequestPresenter object, given the necessary view models.
     *
     * @param viewManagerModel The model responsible for displaying the current view to the user.
     * @param createRequestViewModel The model responsible for managing state changes for the createRequest view.
     * @param viewRequestViewModel The model responsible for managing state changes for the viewRequest view.
     */
    public CreateRequestPresenter(ViewManagerModel viewManagerModel,
                                  CreateRequestViewModel createRequestViewModel,
                                  ViewRequestViewModel viewRequestViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createRequestViewModel = createRequestViewModel;
        this.viewRequestViewModel = viewRequestViewModel;
    }

    /**
     * Show the details of the newly created request on the ViewRequestView.
     *
     * @param response Data object containing the created request, and patient for which it was created for.
     */
    @Override
    public void prepareSuccessView(CreateRequestOutputData response) {
        // Create a new ViewRequestState whose response instance attribute is the newly generated response
        ViewRequestState viewRequestState = this.viewRequestViewModel.getState();
        viewRequestState.setRequest(response.getRequest());

        // set the viewRequestModel's new state, alert the view of the changes
        this.viewRequestViewModel.setState(viewRequestState);
        viewRequestViewModel.firePropertyChanged();

        // change the active view, and alert the main view
        this.viewManagerModel.setActiveView(viewRequestViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Show the error message on the current view.
     *
     * @param error The error message to be displayed.
     */
    @Override
    public void prepareFailView(String error) {
        // Create a new CreateRequestState with the given error message
        CreateRequestState createRequestState = createRequestViewModel.getState();
        createRequestState.setCreateRequestError(error);

        // alert the view of the state change
        this.createRequestViewModel.setState(createRequestState);
        createRequestViewModel.firePropertyChanged();
    }
}