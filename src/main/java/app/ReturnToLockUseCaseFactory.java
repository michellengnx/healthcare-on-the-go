package app;

import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.LockView.LockPresenter;
import interface_adapter.LockView.LockViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ReturnHome.ReturnHomePresenter;
import interface_adapter.ReturnToLock.ReturnToLockController;
import interface_adapter.ReturnToLock.ReturnToLockPresenter;
import interface_adapter.ViewManagerModel;
import use_case.ReturnHome.ReturnHomeInputBoundary;
import use_case.ReturnHome.ReturnHomeInteractor;
import use_case.ReturnHome.ReturnHomeOutputBoundary;
import use_case.ReturnToLock.ReturnToLockInputBoundary;
import use_case.ReturnToLock.ReturnToLockInteractor;

public class ReturnToLockUseCaseFactory {
    /**
     * Return a ReturnHomeController that executes the return home use case in its entirety, i.e., set the current view
     * to that of the home screen.
     *
     * @param viewManagerModel The view model whose active view is to be set to the home screen.
     * @param lockViewModel The view model whose view corresponds to the home screen.
     * @return A controller used to execute the return home use case.
     */
    public static ReturnToLockController create(ViewManagerModel viewManagerModel, LockViewModel lockViewModel) {
        ReturnToLockPresenter returnToLockPresenter = new ReturnToLockPresenter(viewManagerModel, lockViewModel);

        ReturnToLockInputBoundary returnToLockInteractor = new ReturnToLockInteractor(returnToLockPresenter);

        return new ReturnToLockController(returnToLockInteractor);
    }
}
