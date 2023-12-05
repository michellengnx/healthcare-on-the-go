package app;

import use_case.ViewRequest.RequestDataAccess;
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

/**
 * Factory class to create the ViewRequestsView and its dependencies.
 */
public class ViewRequestUseCaseFactory {

    /**
     * Creates a ViewRequestsView instance with the necessary dependencies.
     *
     * @param viewManagerModel   The view manager model.
     * @param viewRequestViewModel The view request view model.
     * @param requestDataAccess  The request data access object.
     * @param returnHomeController The return home controller.
     * @return The created ViewRequestsView.
     */
    public static ViewRequestsView create(
            ViewManagerModel viewManagerModel,
            ViewRequestViewModel viewRequestViewModel,
            RequestDataAccess requestDataAccess,
            ReturnHomeController returnHomeController
            ) {
        try {
            ViewRequestController viewRequestController = createViewRequestUseCase(viewManagerModel, viewRequestViewModel, requestDataAccess);
            return new ViewRequestsView(viewRequestViewModel, viewRequestController, returnHomeController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Creates a ViewRequestController instance with the required dependencies.
     *
     * @param viewManagerModel   The view manager model.
     * @param viewRequestViewModel The view request view model.
     * @param requestDataAccess  The request data access object.
     * @return The created ViewRequestController.
     * @throws IOException If there's an issue with file I/O.
     */
    private static ViewRequestController createViewRequestUseCase(ViewManagerModel viewManagerModel,
                                                                  ViewRequestViewModel viewRequestViewModel,
                                                                  RequestDataAccess requestDataAccess) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        ViewRequestOutputBoundary viewRequestOutputBoundary = new ViewRequestPresenter(viewManagerModel, viewRequestViewModel);

        ViewRequestInteractor viewRequestInputBoundary = new ViewRequestInteractor(
                requestDataAccess,
                viewRequestOutputBoundary);

        return new ViewRequestController(viewRequestInputBoundary);
    }
}
