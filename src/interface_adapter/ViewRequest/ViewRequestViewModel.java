package interface_adapter.ViewRequest;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

// TODO : IMPLEMENT

public class ViewRequestViewModel extends ViewModel {
    public ViewRequestViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public ViewRequestState getState() {
        return new ViewRequestState();
    }

    public void setState(ViewRequestState viewRequestState) {
    }
}
