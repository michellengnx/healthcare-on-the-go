package interface_adapter.ReturnHome;

import use_case.ReturnHome.ReturnHomeInputBoundary;
import use_case.ReturnHome.ReturnHomeInteractor;

public class ReturnHomeController {
    ReturnHomeInputBoundary returnHomeInteractor;

    public ReturnHomeController(ReturnHomeInputBoundary returnHomeInteractor) {
        this.returnHomeInteractor = returnHomeInteractor;
    }

    public void execute() {
        this.returnHomeInteractor.execute();
    }
}
