package interface_adapter.ViewRequest;

import use_case.ViewRequest.ViewRequestUseCase;

public class RequestController {
    private ViewRequestUseCase viewRequestUseCase;

    public RequestController(ViewRequestUseCase viewRequestUseCase) {
        this.viewRequestUseCase = viewRequestUseCase;
    }

    public ViewRequestViewModel viewRequest(String userName) {
        var request = viewRequestUseCase.getRequestDetails(userName);
        return new ViewRequestViewModel(request);
    }
    }

