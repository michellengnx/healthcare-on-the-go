package interface_adapter.LockView;

import use_case.LockView.LockInputBoundary;
import use_case.Login.LoginInputBoundary;
import use_case.Login.LoginInputData;

/**
 * Controller handling locking functionalities in the application.
 */
public class LockController {
    final LockInputBoundary lockUseCaseInteractor;

    /**
     * Constructs a LockController with a LockInputBoundary.
     *
     * @param lockUseCaseInteractor The interactor handling locking use cases.
     */
    public LockController(LockInputBoundary lockUseCaseInteractor) {
        this.lockUseCaseInteractor = lockUseCaseInteractor;
    }


    /**
     * Executes the locking action based on the provided view name.
     *
     * @param viewName The name of the view triggering the locking action.
     */
    public void execute(String viewName) {
        lockUseCaseInteractor.execute(viewName);
    }
}
