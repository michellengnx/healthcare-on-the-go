package use_case.ReturnHome;

/**
 * Use case interactor to return to the home screen.
 */
public class ReturnHomeInteractor implements ReturnHomeInputBoundary {
    ReturnHomeOutputBoundary returnHomePresenter;

    /**
     * Create ReturnHomeInteractor object.
     *
     * @param returnHomePresenter The presenter called upon when the use case is executed.
     */
    public ReturnHomeInteractor(ReturnHomeOutputBoundary returnHomePresenter) {
        this.returnHomePresenter = returnHomePresenter;
    }

    /**
     * Call on the presenter, setting the view to the home screen.
     */
    @Override
    public void execute() {
        this.returnHomePresenter.prepareSuccessView();
    }
}
