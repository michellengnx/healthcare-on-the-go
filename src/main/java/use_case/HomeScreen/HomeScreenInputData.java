package use_case.HomeScreen;

public class HomeScreenInputData {
    private String viewName;

    /**
     * Create a HomeScreenInputData given the name of the view to switch to.
     *
     * @param viewName Name of the view to switch to.
     */

    public HomeScreenInputData(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }
}
