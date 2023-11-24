package interface_adapter.controllers;

import use_case.ViewRequestUseCase;
import interface_adapter.presenters.RequestViewModel;

public class RequestController {
    private ViewRequestUseCase viewRequestUseCase;

    public RequestController(ViewRequestUseCase viewRequestUseCase) {
        this.viewRequestUseCase = viewRequestUseCase;
    }

    public RequestViewModel viewRequest(String userName) {
        var request = viewRequestUseCase.getRequestDetails(userName);
        return new RequestViewModel(request);
    }
    }

