package app;

import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenController;
import interface_adapter.HomeScreen.HomeScreenPresenter;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.HomeScreen.HomeScreenInputBoundary;
import use_case.HomeScreen.HomeScreenInteractor;
import use_case.HomeScreen.HomeScreenOutputBoundary;
import view.HomeScreenView;

public class HomeScreenUseCaseFactory {
    public static HomeScreenView create(ViewManagerModel viewManagerModel,
                                           CreateRequestViewModel createRequestViewModel,
                                           ViewRequestViewModel viewRequestViewModel,
                                           HomeScreenViewModel homeScreenViewModel) {
        HomeScreenController homeScreenController = createHomeScreenUseCase(
                viewManagerModel,
                createRequestViewModel,
                viewRequestViewModel,
                homeScreenViewModel);
        return new HomeScreenView(homeScreenController, homeScreenViewModel);

    }

    private static HomeScreenController createHomeScreenUseCase(ViewManagerModel viewManagerModel,
                                                                CreateRequestViewModel createRequestViewModel,
                                                                ViewRequestViewModel viewRequestViewModel,
                                                                HomeScreenViewModel homeScreenViewModel) {

        HomeScreenOutputBoundary homeScreenOutputBoundary = new HomeScreenPresenter(
                createRequestViewModel,
                viewRequestViewModel,
                viewManagerModel,
                homeScreenViewModel);

        HomeScreenInputBoundary homeScreenInputBoundary = new HomeScreenInteractor(
                homeScreenOutputBoundary);

        return new HomeScreenController(homeScreenInputBoundary);
    }
}
