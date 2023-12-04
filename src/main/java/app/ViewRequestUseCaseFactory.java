package app;

import use_case.ViewRequest.RequestDataAccessInterface;
import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestController;
import interface_adapter.ViewRequest.ViewRequestPresenter;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.ViewRequest.ViewRequestInteractor;
import use_case.ViewRequest.ViewRequestOutputBoundary;
import view.ViewRequestsView;

import javax.swing.*;
import java.io.IOException;

public class ViewRequestUseCaseFactory {
    public static ViewRequestsView create(
            ViewManagerModel viewManagerModel,
            ViewRequestViewModel viewRequestViewModel,
            RequestDataAccessInterface requestDataAccessInterface,
            ReturnHomeController returnHomeController
            ) {
        try {
            ViewRequestController viewRequestController = createViewRequestUseCase(viewManagerModel, viewRequestViewModel, requestDataAccessInterface);
            return new ViewRequestsView(viewRequestViewModel, viewRequestController, returnHomeController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }


    private static ViewRequestController createViewRequestUseCase(ViewManagerModel viewManagerModel,
                                                                  ViewRequestViewModel viewRequestViewModel,
                                                                  RequestDataAccessInterface requestDataAccessInterface) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        ViewRequestOutputBoundary viewRequestOutputBoundary = new ViewRequestPresenter(viewManagerModel, viewRequestViewModel);

        ViewRequestInteractor viewRequestInputBoundary = new ViewRequestInteractor(
                requestDataAccessInterface,
                viewRequestOutputBoundary);

        return new ViewRequestController(viewRequestInputBoundary);
    }
}
