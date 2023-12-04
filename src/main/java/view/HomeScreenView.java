package view;

import entities.Service;
import interface_adapter.CreateRequest.CreateRequestController;
import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenController;
import interface_adapter.HomeScreen.HomeScreenState;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ViewRequest.ViewRequestController;
import interface_adapter.edit_profile.EditController;
import interface_adapter.edit_profile.EditViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
    private final JButton editProfile;
    private final JButton logout;
    private final JPanel requestView;

    private final HomeScreenController homeScreenController;
    private final ViewRequestController viewRequestController;

    private final JLabel title;
    private final JLabel map;

    /**
     * Create a CreateRequestView object given the appropriate view model and controllers.
     *
     * @param homeScreenController The controller responsible for executing the use case that switches the view.
     * @param homeScreenViewModel The view model storing the data relevant to the home screen UI elements
     */
    public HomeScreenView(HomeScreenController homeScreenController,
                          HomeScreenViewModel homeScreenViewModel,
                          ViewRequestController viewRequestController) {
        this.viewRequestController = viewRequestController;
        this.homeScreenController = homeScreenController;
        this.homeScreenViewModel = homeScreenViewModel;
        homeScreenViewModel.addPropertyChangeListener(this);

        // screen title
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center align components
        title = new JLabel("Hello " + homeScreenViewModel.getState().getPatient() + " " + "\uD83D\uDC4B");
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(title);


        URL url;
        BufferedImage image;

        try {
            url = new URL("https://re-mm-assets.s3.amazonaws.com/product_photo/46595/large_large_Poly_Lime_374u_1471509935.jpg");
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }

        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException();
        }

        // buttons to create request and return home
        // Bottom panel for buttons in a grid layout
        createRequest = new JButton(homeScreenViewModel.CREATE_REQUEST_BUTTON_LABEL);
        viewRequests = new JButton(homeScreenViewModel.VIEW_REQUESTS_BUTTON_LABEL);
        leaveReview = new JButton(homeScreenViewModel.LEAVE_REVIEW_BUTTON_LABEL);
        editProfile = new JButton(homeScreenViewModel.EDIT_PROFILE_BUTTON_LABEL);
        logout = new JButton(homeScreenViewModel.LOGOUT_BUTTON_LABEL);

        requestView = new JPanel();
        requestView.setAlignmentX(Component.CENTER_ALIGNMENT);
        map = new JLabel(new ImageIcon(image));
        JLabel docOtw = new JLabel(homeScreenViewModel.DOCTOR_OTW_LABEL);
        docOtw.setAlignmentX(Component.CENTER_ALIGNMENT);
        requestView.add(docOtw);
        requestView.add(map);
        requestView.setVisible(false);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 2, 5, 5)); // 2 rows, 2 columns, spacing
        bottomPanel.add(createRequest);
        bottomPanel.add(viewRequests);
        bottomPanel.add(leaveReview);
        bottomPanel.add(editProfile);

        // Panel for the logout button positioned at the top right corner
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        logoutPanel.add(logout);



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
                        viewRequestController.execute(homeScreenViewModel.getState().getPatient());
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

        editProfile.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        switchScreen(evt, editProfile, "edit profile");
                    }
                }
        );

        this.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(requestView, BorderLayout.CENTER);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(logoutPanel, BorderLayout.NORTH);


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
        HomeScreenState homeScreenState = (HomeScreenState) evt.getNewValue();
        this.requestView.setVisible(homeScreenState.isActiveRequest());
        this.title.setText("Hello " + homeScreenState.getPatient());
        URL url;
        BufferedImage image;

        try {
            url = new URL(homeScreenState.getImageUrl());
            image = ImageIO.read(url);
            ImageIcon myMap = new ImageIcon(image);
            this.map.setIcon(myMap);
        } catch (IOException e) {

        }
    }

    /**
     * Switch the current screen based ono which button is pressed.
     *
     * @param evt The event.
     * @param buttonPressed The button pressed.
     * @param viewName The name of the view to switch to
     */
    private void switchScreen(ActionEvent evt, JButton buttonPressed, String viewName) {
        HomeScreenState homeScreenState = homeScreenViewModel.getState();
        homeScreenViewModel.setState(homeScreenState);
        homeScreenViewModel.firePropertyChanged();

        if (evt.getSource().equals(buttonPressed)) {
            homeScreenController.execute(
                    viewName
            );
        }

        requestView.setVisible(false);
    }
}
