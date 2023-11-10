package view;

import entities.Service;
import interface_adapter.CreateRequest.CreateRequestController;
import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

/**
 * View that displays the necessary interface for a patient create a new request, and a way to return to the home
 * screen.
 */
public class CreateRequestView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "create request";

    private final CreateRequestViewModel createRequestViewModel;

    private final Integer[] urgencyLevels = {1, 2, 3};
    private final Service[] availableServiceNames = {
            new Service("Vaccination", 20),
            new Service("Nutritional support", 10),
            new Service("Pharmaceutical services", 40),
            new Service("General health check", 60),
            new Service("X-ray imaging", 100),
            new Service("Blood testing", 70),
            new Service("Psychological care", 150)
    };

    private final JComboBox<Integer> urgencyLevelComboBox = new JComboBox<>(urgencyLevels);
    private final JComboBox<Service> availableServiceComboBox = new JComboBox<>(availableServiceNames);
    private final JTextField destinationInputField = new JTextField(30);
    private final JButton createRequest;
    private final JButton cancel;

    private final CreateRequestController createRequestController;
    private final ReturnHomeController returnHomeController;

    /**
     * Create a CreateRequestView object given the appropriate view model and controllers.
     *
     * @param createRequestController The controller responsible for executing the use case that creates a request.
     * @param returnHomeController The controller responsible for executing the use case that sets the view to the
     *                             home view.
     * @param createRequestViewModel The view model responsible for storing label values and the view's state.
     */
    public CreateRequestView(CreateRequestController createRequestController,
                             ReturnHomeController returnHomeController,
                             CreateRequestViewModel createRequestViewModel) {
        this.createRequestController = createRequestController;
        this.returnHomeController = returnHomeController;
        this.createRequestViewModel = createRequestViewModel;
        createRequestViewModel.addPropertyChangeListener(this);

        // screen title
        JLabel title = new JLabel(createRequestViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // combo boxes and text panels to input the request data
        urgencyLevelComboBox.setSelectedItem(1);
        LabelComboBoxPanel urgencyLevelSelect = new LabelComboBoxPanel(
                new JLabel(createRequestViewModel.URGENCY_LABEL), urgencyLevelComboBox
        );
        availableServiceComboBox.setSelectedItem(new Service("Vaccination", 20));
        LabelComboBoxPanel serviceSelect = new LabelComboBoxPanel(
                new JLabel(createRequestViewModel.SERVICE_LABEL), availableServiceComboBox
        );
        LabelTextPanel destinationInfo = new LabelTextPanel(
                new JLabel(createRequestViewModel.DESTINATION_LABEL), destinationInputField);

        // buttons to create request and return home
        JPanel buttons = new JPanel();
        createRequest = new JButton(createRequestViewModel.CREATE_REQUEST_BUTTON_LABEL);
        buttons.add(createRequest);
        cancel = new JButton(createRequestViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        // create the request with the data in the view's state when the createRequest button is clicked
        createRequest.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createRequest)) {
                            CreateRequestState currentState = createRequestViewModel.getState();
                            createRequestController.execute(
                                    new Date(),
                                    currentState.getUrgencyLevel(),
                                    currentState.getDestination(),
                                    currentState.getService(),
                                    currentState.getPatient()
                            );
                        }
                    }
                }
        );

        // return to the home screen when cancel button is clicked
        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancel)) {
                            returnHomeController.execute();
                        }
                    }
                }
        );

        urgencyLevelComboBox.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(urgencyLevelComboBox)) {
                            CreateRequestState currentState = createRequestViewModel.getState();
                            JComboBox<Integer> myCombo = (JComboBox<Integer>) evt.getSource();
                            Integer newUrgencyLevel = (Integer)myCombo.getSelectedItem();
                            currentState.setUrgencyLevel(newUrgencyLevel);
                        }
                    }
                }
        );

        availableServiceComboBox.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(availableServiceComboBox)) {
                            CreateRequestState currentState = createRequestViewModel.getState();
                            JComboBox<Service> myCombo = (JComboBox<Service>) evt.getSource();
                            Service newService = (Service)myCombo.getSelectedItem();
                            currentState.setService(newService);
                        }
                    }
                }
        );

        destinationInputField.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(destinationInputField)) {
                            CreateRequestState currentState = createRequestViewModel.getState();
                            JTextField destinationText = (JTextField) evt.getSource();
                            String newDestination = (String)destinationText.getText();
                            currentState.setDestination(newDestination);
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(urgencyLevelSelect);
        this.add(serviceSelect);
        this.add(destinationInfo);
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
        CreateRequestState createRequestState = (CreateRequestState) evt.getNewValue();
        if (createRequestState.getCreateRequestError() != null) {
            JOptionPane.showMessageDialog(this, createRequestState.getCreateRequestError());
        }
    }
}
