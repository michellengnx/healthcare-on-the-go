package interface_adapter.ReturnHome;

import interface_adapter.ViewManagerModel;
import use_case.ReturnHome.ReturnHomeOutputBoundary;

public class ReturnHomePresenter implements ReturnHomeOutputBoundary {
    ViewManagerModel viewManagerModel;
    HomeScreenViewModel homeScreenViewModel;

    public ReturnHomePresenter(ViewManagerModel viewManagerModel,
                               HomeScreenViewModel homeScreenViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeScreenViewModel = homeScreenViewModel;
    }

    @Override
    public void prepareSuccessView() {
        this.viewManagerModel.setActiveView(this.homeScreenViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
