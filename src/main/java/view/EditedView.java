package view;

import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.edited_profile.EditedState;
import interface_adapter.edited_profile.EditedViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Represents the view for displaying an edited profile.
 */
public class EditedView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "edited";
    private final EditedViewModel editedViewModel;
    JLabel password;
    JLabel email;
    JLabel phoneNumber;
    JLabel insurance;
    JLabel creditCardName;
    JLabel cvv;
    JLabel expirationDate;
    JLabel nameOnCard;
    JLabel emergencyName;
    JLabel emergencyNumber;
    JLabel emergencyRelationship;
    final JButton returnHomePage;

    /**
     * Constructs an EditedView object.
     * * A window with a title and a JButton.
     * @param editedViewModel The view model associated with the edited profile view.
     */
    public EditedView(EditedViewModel editedViewModel,
                      ReturnHomeController returnHomeController) {
        this.editedViewModel = editedViewModel;
        this.editedViewModel.addPropertyChangeListener(this);

        password = new JLabel();
        email = new JLabel();
        phoneNumber = new JLabel();
        insurance = new JLabel();
        creditCardName = new JLabel();
        cvv = new JLabel();
        expirationDate = new JLabel();
        nameOnCard = new JLabel();
        emergencyName = new JLabel();
        emergencyNumber = new JLabel();
        emergencyRelationship = new JLabel();


        JPanel buttons = new JPanel();
        returnHomePage = new JButton(editedViewModel.EXIT_BUTTON_LABEL);

        returnHomePage.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(returnHomePage)) {
                            returnHomeController.execute();
                        }
                    }
                }
        );

        buttons.add(returnHomePage);

        returnHomePage.addActionListener(this);

        this.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel title = new JLabel("Edited Profile Screen");
        titlePanel.add(title);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10); // Padding


        centerPanel.add(new JLabel("Changes have been successfully saved: "), gbc);
        centerPanel.add(password, gbc);
        centerPanel.add(email, gbc);
        centerPanel.add(insurance, gbc);
        centerPanel.add(creditCardName, gbc);
        centerPanel.add(cvv, gbc);
        centerPanel.add(expirationDate, gbc);
        centerPanel.add(nameOnCard, gbc);
        centerPanel.add(emergencyName, gbc);
        centerPanel.add(emergencyNumber, gbc);
        centerPanel.add(emergencyRelationship, gbc);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(returnHomePage);


        this.add(titlePanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Handles changes in the property.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditedState state = (EditedState) evt.getNewValue();
        password.setText(state.getPassword());
        email.setText(state.getEmail());
        phoneNumber.setText(state.getPhoneNumber());
        insurance.setText(state.getInsurance());
        creditCardName.setText(state.getCreditCardNumber());
        cvv.setText(String.valueOf(state.getCvv()));
        expirationDate.setText(state.getExpirationDate());
        nameOnCard.setText(state.getNameOnCard());
        emergencyName.setText(state.getEmergencyName());
        emergencyNumber.setText(state.getEmergencyNumber());
        emergencyRelationship.setText(state.getEmergencyRelationship());


    }
}
