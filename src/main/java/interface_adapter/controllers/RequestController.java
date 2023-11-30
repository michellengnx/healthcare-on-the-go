package interface_adapter.controllers;

import use_case.ViewRequestUseCase;
import interface_adapter.ViewRequest.ViewRequestViewModel;

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

