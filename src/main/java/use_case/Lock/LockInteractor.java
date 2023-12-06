package use_case.Lock;

/**
 * Represents the interactor responsible for the locking operation.
 * Implements LockInputBoundary.
 */
public class LockInteractor implements LockInputBoundary {
    LockOutputBoundary lockPresenter;

    public LockInteractor(LockOutputBoundary lockPresenter) {
        this.lockPresenter = lockPresenter;
    }

    public void execute(String viewName) {
        lockPresenter.prepareSuccessView(viewName);
    }
}
