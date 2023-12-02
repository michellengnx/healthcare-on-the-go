package use_case.HomeScreen;

public interface HomeScreenInputBoundary {
    /**
     * Execute the homeScreen use case, i.e. switch to the appropriate view.
     *
     * @param homeScreenInputData Input data containing the name of the view to switch to
     */
    public void execute(HomeScreenInputData homeScreenInputData);
}
