package use_case.ReturnToLock;

/**
 * Use case interactor to return to the home screen.
 */
public class ReturnToLockInteractor implements ReturnToLockInputBoundary {
    ReturnToLockOutputBoundary returnToLockPresenter;

    /**
     * Create ReturnToLockInteractor object.
     *
     * @param returnToLockPresenter The presenter called upon when the use case is executed.
     */
    public ReturnToLockInteractor(ReturnToLockOutputBoundary returnToLockPresenter) {
        this.returnToLockPresenter = returnToLockPresenter;
    }

    /**
     * Call on the presenter, setting the view to the home screen.
     */
    @Override
    public void execute() {
        this.returnToLockPresenter.prepareSuccessView();
    }
}
