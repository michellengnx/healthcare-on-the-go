package use_case.ReturnHome;

public class ReturnHomeInteractor implements ReturnHomeInputBoundary{
    ReturnHomeOutputBoundary returnHomePresenter;

    public ReturnHomeInteractor(ReturnHomeOutputBoundary returnHomePresenter) {
        this.returnHomePresenter = returnHomePresenter;
    }

    @Override
    public void execute() {
        this.returnHomePresenter.prepareSuccessView();
    }
}
