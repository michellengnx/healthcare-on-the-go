package view;

import entities.Service;
import interface_adapter.CreateRequest.CreateRequestController;
import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.CreateRequest.CreateRequestViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

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
    private final CreateRequestController createRequestController;

    private final JButton createRequest;
    private final JButton cancel;

    public CreateRequestView(CreateRequestController controller, CreateRequestViewModel createRequestViewModel) {
        this.createRequestController = controller;
        this.createRequestViewModel = createRequestViewModel;
        createRequestViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(createRequestViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelComboBoxPanel urgencyLevelSelect = new LabelComboBoxPanel(
                new JLabel(createRequestViewModel.URGENCY_LABEL), urgencyLevelComboBox
        );
        LabelComboBoxPanel serviceSelect = new LabelComboBoxPanel(
                new JLabel(createRequestViewModel.SERVICE_LABEL), availableServiceComboBox
        );
        LabelTextPanel destinationInfo = new LabelTextPanel(
                new JLabel(createRequestViewModel.DESTINATION_LABEL), destinationInputField);

        JPanel buttons = new JPanel();
        createRequest = new JButton(createRequestViewModel.CREATE_REQUEST_BUTTON_LABEL);
        buttons.add(createRequest);
        cancel = new JButton(createRequestViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

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

        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancel)) {
                            return;
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
