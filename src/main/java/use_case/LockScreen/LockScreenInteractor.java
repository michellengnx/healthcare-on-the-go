package use_case.LockScreen;

public class LockScreenInteractor implements LockScreenInputBoundary {
    LockScreenOutputBoundary lockPresenter;

    public LockScreenInteractor(LockScreenOutputBoundary lockPresenter) {
        this.lockPresenter = lockPresenter;
    }

    public void execute(String viewName) {
        lockPresenter.prepareSuccessView(viewName);
    }
}
