package interface_adapter.ReturnToLock;

import interface_adapter.LockView.LockViewModel;
import interface_adapter.ViewManagerModel;
import use_case.ReturnToLock.ReturnToLockOutputBoundary;

/**
 * Presenter that will switch the current screen to the home screen.
 */
public class ReturnToLockPresenter implements ReturnToLockOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LockViewModel lockScreenModel;

    /**
     * Create ReturnHomePresenter object given a view manager model and home screen view model.
     *
     * @param viewManagerModel The view manager model whose screen is to be switched.
     * @param lockScreenModel The model belonging to the home screen to be switched to.
     */
    public ReturnToLockPresenter(ViewManagerModel viewManagerModel,
                                 LockViewModel lockScreenModel) {
        this.viewManagerModel = viewManagerModel;
        this.lockScreenModel = lockScreenModel;
    }

    /**
     * Switch the active view of the viewManagerModel to the screen which the homeScreenView model belongs to.
     */
    @Override
    public void prepareSuccessView() {
        System.out.println("lock view");
        this.viewManagerModel.setActiveView(lockScreenModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
