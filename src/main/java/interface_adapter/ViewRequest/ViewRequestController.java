package interface_adapter.ViewRequest;

import use_case.ViewRequest.ViewRequestInputData;
import use_case.ViewRequest.ViewRequestInteractor;

/**
 * Controller handling interactions between the View layer and the ViewRequestInteractor.
 */
public class ViewRequestController {
    private ViewRequestInteractor viewRequestInteractor;

    /**
     * Constructs a ViewRequestController instance.
     *
     * @param viewRequestInteractor The interactor handling view request interactions.
     */
    public ViewRequestController(ViewRequestInteractor viewRequestInteractor) {
        this.viewRequestInteractor = viewRequestInteractor;
    }

    /**
     * Retrieves view request details for a specific user.
     *
     * @param userName The username to fetch request details for.
     * @return The ViewRequestViewModel containing the request details.
     */
    public ViewRequestViewModel viewRequest(String userName) {
        var request = viewRequestInteractor.getRequestDetails(userName);
        ViewRequestViewModel viewRequestViewModel = new ViewRequestViewModel();
        ViewRequestState viewRequestState = new ViewRequestState(request);
        viewRequestViewModel.setViewRequestState(viewRequestState);
        return viewRequestViewModel;
    }

    /**
     * Executes a view request operation for a specific username.
     *
     * @param username The username for which the view request operation is executed.
     */
    public void execute(String username) {
        viewRequestInteractor.execute(new ViewRequestInputData(username));
    }

    }

