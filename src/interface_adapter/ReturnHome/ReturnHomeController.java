package interface_adapter.ReturnHome;

import use_case.ReturnHome.ReturnHomeInputBoundary;
import use_case.ReturnHome.ReturnHomeInteractor;

/**
 * The controller responsible for executing the return home use case interactor.
 */
public class ReturnHomeController {
    ReturnHomeInputBoundary returnHomeInteractor;

    /**
     * Create a ReturnHomeController object given an input boundary for the return home use case.
     *
     * @param returnHomeInteractor The use case interactor for returning to the home screen.
     */
    public ReturnHomeController(ReturnHomeInputBoundary returnHomeInteractor) {
        this.returnHomeInteractor = returnHomeInteractor;
    }

    /**
     * Execute the return home use case interactor.
     */
    public void execute() {
        this.returnHomeInteractor.execute();
    }
}
