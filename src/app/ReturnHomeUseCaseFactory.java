package app;

import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ReturnHome.ReturnHomePresenter;
import interface_adapter.ViewManagerModel;
import use_case.ReturnHome.ReturnHomeInputBoundary;
import use_case.ReturnHome.ReturnHomeInteractor;
import use_case.ReturnHome.ReturnHomeOutputBoundary;

public class ReturnHomeUseCaseFactory {
    public static ReturnHomeController create(ViewManagerModel viewManagerModel, HomeScreenViewModel homeScreenViewModel) {
        return createReturnHomeUseCase(viewManagerModel, homeScreenViewModel);
    }

    public static ReturnHomeController createReturnHomeUseCase(ViewManagerModel viewManagerModel, HomeScreenViewModel homeScreenViewModel) {
        ReturnHomeOutputBoundary returnHomeOutputBoundary = new ReturnHomePresenter(viewManagerModel, homeScreenViewModel);

        ReturnHomeInputBoundary returnHomeInteractor = new ReturnHomeInteractor(returnHomeOutputBoundary);

        return new ReturnHomeController(returnHomeInteractor);
    }
}
