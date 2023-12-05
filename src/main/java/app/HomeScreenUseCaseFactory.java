package app;

import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenController;
import interface_adapter.HomeScreen.HomeScreenPresenter;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.LockView.LockViewModel;
import interface_adapter.LockView.LockViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestController;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import interface_adapter.edit_profile.EditViewModel;
import use_case.HomeScreen.HomeScreenInputBoundary;
import use_case.HomeScreen.HomeScreenInteractor;
import use_case.HomeScreen.HomeScreenOutputBoundary;
import view.HomeScreenView;

/**
 * Factory class to create the HomeScreenView and its dependencies.
 */
public class HomeScreenUseCaseFactory {

    /**
     * Creates a HomeScreenView instance with the necessary dependencies.
     *
     * @param viewManagerModel       The view manager model.
     * @param createRequestViewModel The create request view model.
     * @param viewRequestViewModel  The view request view model.
     * @param editViewModel         The edit view model.
     * @param lockViewModel         The lock view model.
     * @param homeScreenViewModel   The home screen view model.
     * @param viewRequestController The view request controller.
     * @return The created HomeScreenView.
     */
    public static HomeScreenView create(ViewManagerModel viewManagerModel,
                                        CreateRequestViewModel createRequestViewModel,
                                        ViewRequestViewModel viewRequestViewModel,
                                        EditViewModel editViewModel,
                                        LockViewModel lockViewModel,
                                        HomeScreenViewModel homeScreenViewModel,
                                        ViewRequestController viewRequestController) {
        HomeScreenController homeScreenController = createHomeScreenUseCase(
                viewManagerModel,
                createRequestViewModel,
                viewRequestViewModel,
                editViewModel,
                lockViewModel,
                homeScreenViewModel);
        return new HomeScreenView(homeScreenController, homeScreenViewModel, viewRequestController);

    }

    /**
     * Creates a HomeScreenController instance with the required dependencies.
     *
     * @param viewManagerModel      The view manager model.
     * @param createRequestViewModel The create request view model.
     * @param viewRequestViewModel The view request view model.
     * @param editProfileViewModel The edit profile view model.
     * @param lockViewModel        The lock view model.
     * @param homeScreenViewModel  The home screen view model.
     * @return The created HomeScreenController.
     */

    private static HomeScreenController createHomeScreenUseCase(ViewManagerModel viewManagerModel,
                                                                CreateRequestViewModel createRequestViewModel,
                                                                ViewRequestViewModel viewRequestViewModel,
                                                                EditViewModel editProfileViewModel,
                                                                LockViewModel lockViewModel,
                                                                HomeScreenViewModel homeScreenViewModel) {

        HomeScreenOutputBoundary homeScreenOutputBoundary = new HomeScreenPresenter(
                createRequestViewModel,
                viewRequestViewModel,
                editProfileViewModel,
                viewManagerModel,
                lockViewModel,
                homeScreenViewModel);

        HomeScreenInputBoundary homeScreenInputBoundary = new HomeScreenInteractor(
                homeScreenOutputBoundary);

        return new HomeScreenController(homeScreenInputBoundary);
    }
}
