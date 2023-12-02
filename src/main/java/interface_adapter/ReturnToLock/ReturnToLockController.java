package interface_adapter.ReturnToLock;

import use_case.ReturnHome.ReturnHomeInputBoundary;
import use_case.ReturnToLock.ReturnToLockInputBoundary;

/**
 * The controller responsible for executing the return home use case interactor.
 */
public class ReturnToLockController {
    private final ReturnToLockInputBoundary returnToLockInputBoundary;

    /**
     * Create a ReturnHomeController object given an input boundary for the return home use case.
     *
     * @param returnToLockInputBoundary The use case interactor for returning to the home screen.
     */
    public ReturnToLockController(ReturnToLockInputBoundary returnToLockInputBoundary) {
        this.returnToLockInputBoundary = returnToLockInputBoundary;
    }

    /**
     * Execute the return home use case interactor.
     */
    public void execute() {
        this.returnToLockInputBoundary.execute();
    }
}
