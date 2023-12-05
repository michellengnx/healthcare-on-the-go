package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Manages the active view in the application and supports property change listeners.
 */
public class ViewManagerModel {

    private String activeViewName;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Retrieves the name of the currently active view.
     *
     * @return The name of the active view.
     */
    public String getActiveView() {
        return activeViewName;
    }

    /**
     * Sets the name of the active view.
     *
     * @param activeView The name of the view to set as active.
     */
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    /**
     * Notifies registered listeners about property changes in the active view.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    /**
     * Adds a property change listener to monitor changes in the active view.
     *
     * @param listener The listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}