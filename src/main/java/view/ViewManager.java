package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Manages the views within a CardLayout, allowing navigation between different panels or views
 * based on changes in the ViewManagerModel.
 */
public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a ViewManager to manage views within a CardLayout.
     *
     * @param views             The JPanel containing the views to be managed.
     * @param cardLayout        The CardLayout used to switch between views.
     * @param viewManagerModel  The model representing the state of the views.
     */
    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    /**
     * Listens for property changes in the ViewManagerModel and switches views accordingly.
     *
     * @param evt The property change event triggered by the ViewManagerModel.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }
}
