package interface_adapter.LockScreen;

import use_case.LockScreen.LockScreenInputBoundary;

public class LockController {
    final LockScreenInputBoundary lockUseCaseInteractor;
    public LockController(LockScreenInputBoundary lockUseCaseInteractor) {
        this.lockUseCaseInteractor = lockUseCaseInteractor;
    }


    public void execute(String viewName) {
        lockUseCaseInteractor.execute(viewName);
    }
}
