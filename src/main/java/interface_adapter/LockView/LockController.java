package interface_adapter.LockView;

import use_case.LockView.LockInputBoundary;
import use_case.Login.LoginInputBoundary;
import use_case.Login.LoginInputData;

public class LockController {
    final LockInputBoundary lockUseCaseInteractor;
    public LockController(LockInputBoundary lockUseCaseInteractor) {
        this.lockUseCaseInteractor = lockUseCaseInteractor;
    }


    public void execute(String viewName) {
        lockUseCaseInteractor.execute(viewName);
    }
}
