package interface_adapter.HomeScreen;

import use_case.HomeScreen.HomeScreenInputBoundary;
import use_case.HomeScreen.HomeScreenInputData;

public class HomeScreenController {
    private HomeScreenInputBoundary homeScreenInteractor;

    /**
     * Create a HomeScreenController given the appropriate interactor.
     *
     * @param homeScreenInterator The interactor that will execute the home screen use case.
     */
    public HomeScreenController(HomeScreenInputBoundary homeScreenInterator) {
        this.homeScreenInteractor = homeScreenInterator;
    }

    /**
     * Execute the home screen use case, i.e. switch the screen to viewName.
     *
     * @param viewName The name of the view to be switched to.
     */
    public void execute(String viewName) {
        HomeScreenInputData homeScreenInputData = new HomeScreenInputData(viewName);
        this.homeScreenInteractor.execute(homeScreenInputData);
    }
}
