package use_case.LockView;

import interface_adapter.LockView.LockPresenter;

public class LockInteractor implements LockInputBoundary {
    LockOutputBoundary lockPresenter;

    public LockInteractor(LockOutputBoundary lockPresenter) {
        this.lockPresenter = lockPresenter;
    }

    public void execute(String viewName) {
        lockPresenter.prepareSuccessView(viewName);
    }
}
