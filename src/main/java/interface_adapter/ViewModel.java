package interface_adapter;

import java.beans.PropertyChangeListener;

/**
 * Abstract class representing a view model in the application.
 */
public abstract class ViewModel {

    private final String viewName;

    /**
     * Initializes a ViewModel with a specified view name.
     *
     * @param viewName The name associated with this view model.
     */
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    /**
     * Retrieves the name associated with this view model.
     *
     * @return The name of the view.
     */
    public String getViewName() {
        return this.viewName;
    }

    /**
     * Notifies registered listeners about property changes in the view model.
     */
    public abstract void firePropertyChanged();

    /**
     * Adds a property change listener to monitor changes in the view model.
     *
     * @param listener The listener to be added.
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}