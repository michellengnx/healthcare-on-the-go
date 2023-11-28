package interface_adapter.HomeScreen;

import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomeScreenViewModel extends ViewModel {
    public final String TITLE_LABEL = "Create Request";
    public final String CREATE_REQUEST_BUTTON_LABEL = "Create Request";
    public final String VIEW_REQUESTS_BUTTON_LABEL = "View Requests";
    public final String LEAVE_REVIEW_BUTTON_LABEL = "View Requests";
    public final String LOGOUT_BUTTON_LABEL = "LogOut";
    private CreateRequestState state;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public HomeScreenViewModel() {
        super("home screen");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
