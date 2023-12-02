package interface_adapter.ReturnToLock;

import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.LockView.LockViewModel;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import use_case.ReturnHome.ReturnHomeOutputBoundary;
import use_case.ReturnToLock.ReturnToLockInputBoundary;
import use_case.ReturnToLock.ReturnToLockOutputBoundary;
import view.LockView;

/**
 * Presenter that will switch the current screen to the home screen.
 */
public class ReturnToLockPresenter implements ReturnToLockOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LockViewModel lockViewModel;

    /**
     * Create ReturnHomePresenter object given a view manager model and home screen view model.
     *
     * @param viewManagerModel The view manager model whose screen is to be switched.
     * @param lockViewModel The model belonging to the home screen to be switched to.
     */
    public ReturnToLockPresenter(ViewManagerModel viewManagerModel,
                                 LockViewModel lockViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.lockViewModel = lockViewModel;
    }

    /**
     * Switch the active view of the viewManagerModel to the screen which the homeScreenView model belongs to.
     */
    @Override
    public void prepareSuccessView() {
        System.out.println("lock view");
        this.viewManagerModel.setActiveView(lockViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
