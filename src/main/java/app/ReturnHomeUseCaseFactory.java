package app;

import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ReturnHome.ReturnHomePresenter;
import interface_adapter.ViewManagerModel;
import use_case.ReturnHome.ReturnHomeInputBoundary;
import use_case.ReturnHome.ReturnHomeInteractor;
import use_case.ReturnHome.ReturnHomeOutputBoundary;

/**
 * Factory used to create controller for the return home use case.
 */
public class ReturnHomeUseCaseFactory {
    /**
     * Return a ReturnHomeController that executes the return home use case in its entirety, i.e., set the current view
     * to that of the home screen.
     *
     * @param viewManagerModel The view model whose active view is to be set to the home screen.
     * @param homeScreenViewModel The view model whose view corresponds to the home screen.
     * @return A controller used to execute the return home use case.
     */
    public static ReturnHomeController create(ViewManagerModel viewManagerModel, HomeScreenViewModel homeScreenViewModel) {
        ReturnHomeOutputBoundary returnHomeOutputBoundary = new ReturnHomePresenter(viewManagerModel, homeScreenViewModel);

        ReturnHomeInputBoundary returnHomeInteractor = new ReturnHomeInteractor(returnHomeOutputBoundary);

        return new ReturnHomeController(returnHomeInteractor);
    }
}