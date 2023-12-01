package interface_adapter.ViewRequest;

import use_case.ViewRequest.ViewRequestInteractor;

public class ViewRequestController {
    private ViewRequestInteractor viewRequestInteractor;

    public ViewRequestController(ViewRequestInteractor viewRequestInteractor) {
        this.viewRequestInteractor = viewRequestInteractor;
    }

    public ViewRequestViewModel viewRequest(String userName) {
        var request = viewRequestInteractor.getRequestDetails(userName);
        ViewRequestViewModel viewRequestViewModel = new ViewRequestViewModel();
        ViewRequestState viewRequestState = new ViewRequestState(request);
        viewRequestViewModel.setViewRequestState(viewRequestState);
        return viewRequestViewModel;
    }
    }

