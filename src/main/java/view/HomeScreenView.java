package view;

import entities.Service;
import interface_adapter.CreateRequest.CreateRequestController;
import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenController;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

/**
 * View that displays the necessary interface for a patient create a new request, and a way to return to the home
 * screen.
 */
public class HomeScreenView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "home screen";

    private final HomeScreenViewModel homeScreenViewModel;
    private final JButton createRequest;
    private final JButton viewRequests;
    private final JButton leaveReview;
    private final JButton logout;

    private final HomeScreenController homeScreenController;

    /**
     * Create a CreateRequestView object given the appropriate view model and controllers.
     *
     * @param homeScreenController The controller responsible for executing the use case that switches the view.
     * @param homeScreenViewModel The view model storing the data relevant to the home screen UI elements
     */
    public HomeScreenView(HomeScreenController homeScreenController,
                          HomeScreenViewModel homeScreenViewModel) {
        this.homeScreenController = homeScreenController;
        this.homeScreenViewModel = homeScreenViewModel;
        homeScreenViewModel.addPropertyChangeListener(this);

        // screen title
        JLabel title = new JLabel(homeScreenViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // buttons to create request and return home
        JPanel buttons = new JPanel();
        createRequest = new JButton(homeScreenViewModel.CREATE_REQUEST_BUTTON_LABEL);
        buttons.add(createRequest);
        viewRequests = new JButton(homeScreenViewModel.VIEW_REQUESTS_BUTTON_LABEL);
        buttons.add(viewRequests);
        leaveReview = new JButton(homeScreenViewModel.LEAVE_REVIEW_BUTTON_LABEL);
        buttons.add(leaveReview);
        logout = new JButton(homeScreenViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logout);

        // create the request with the data in the view's state when the createRequest button is clicked
        createRequest.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        switchScreen(evt, createRequest, "create request");
                    }
                }
        );
        logout.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        switchScreen(evt, logout, "logout");
                    }
                }
        );
        viewRequests.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        switchScreen(evt, viewRequests, "view requests");
                    }
                }
        );
        leaveReview.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        switchScreen(evt, leaveReview, "leave review");
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    /**
     * Action to be performed when the view is interacted with (nothing).
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * If there is a change in state, check to see whether it is an error. If so, display the error message.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    private void switchScreen(ActionEvent evt, JButton buttonPressed, String viewName) {
        if (evt.getSource().equals(createRequest)) {
            homeScreenController.execute(
                    "create request"
            );
        }
    }
}
