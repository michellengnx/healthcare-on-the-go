package interface_adapter.ReturnHome;

import use_case.ReturnHome.ReturnHomeInteractor;

public class ReturnHomeController {
    ReturnHomeInteractor returnHomeInteractor;

    public ReturnHomeController(ReturnHomeInteractor returnHomeInteractor) {
        this.returnHomeInteractor = returnHomeInteractor;
    }

    public void execute() {
        this.returnHomeInteractor.execute();
    }
}
