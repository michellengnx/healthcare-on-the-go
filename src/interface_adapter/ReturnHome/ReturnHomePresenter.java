package interface_adapter.ReturnHome;

import interface_adapter.ViewManagerModel;
import use_case.ReturnHome.ReturnHomeOutputBoundary;

/**
 * Presenter that will switch the current screen to the home screen.
 */
public class ReturnHomePresenter implements ReturnHomeOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final HomeScreenViewModel homeScreenViewModel;

    /**
     * Create ReturnHomePresenter object given a view manager model and home screen view model.
     *
     * @param viewManagerModel The view manager model whose screen is to be switched.
     * @param homeScreenViewModel The model belonging to the home screen to be switched to.
     */
    public ReturnHomePresenter(ViewManagerModel viewManagerModel,
                               HomeScreenViewModel homeScreenViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeScreenViewModel = homeScreenViewModel;
    }

    /**
     * Switch the active view of the viewManagerModel to the screen which the homeScreenView model belongs to.
     */
    @Override
    public void prepareSuccessView() {
        this.viewManagerModel.setActiveView(homeScreenViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
