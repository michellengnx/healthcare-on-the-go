package use_case.HomeScreen;

public class HomeScreenInteractor implements HomeScreenInputBoundary {
    private HomeScreenOutputBoundary homeScreenPresenter;

    public HomeScreenInteractor(HomeScreenOutputBoundary homeScreenPresenter) {
        this.homeScreenPresenter = homeScreenPresenter;
    }

    /**
     * Switch to the requested view.
     *
     * @param homeScreenInputData Input data containing the name of the view to switch to
     */
    @Override
    public void execute(HomeScreenInputData homeScreenInputData) {
        homeScreenPresenter.prepareSuccessView(homeScreenInputData.getViewName());
    }
}
