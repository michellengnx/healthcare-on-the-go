package interface_adapter.ResolveRequest;

import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.ResolveRequest.ResolveRequestOutputBoundary;

/**
 * Presenter that will update the request being shown.
 */
public class ResolveRequestPresenter implements ResolveRequestOutputBoundary {
    private final ViewRequestViewModel viewRequestViewModel;

    /**
     * Create ViewRequestPresenter object given the view model of the view request use case.
     *
     * @param viewRequestViewModel The view model belonging to the view request use case.
     */
    public ResolveRequestPresenter(ViewRequestViewModel viewRequestViewModel) {
        this.viewRequestViewModel = viewRequestViewModel;
    }

    /**
     * Update the request being shown.
     */
    @Override
    public void prepareSuccessView() {
        this.viewRequestViewModel.firePropertyChanged();
    }

    /**
     * @param errorMsg
     */
    @Override
    public void prepareFailView(String errorMsg) {

    }
}

    /**
     * Set the error message of the viewRequest state.
     *
     * @param error The error message to be sent.
     */

