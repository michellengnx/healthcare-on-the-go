package view;

import interface_adapter.edited_profile.EditedState;
import interface_adapter.edited_profile.EditedViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditedView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "edited";
    private final EditedViewModel editedViewModel;
    JLabel password;
    JLabel email;
    JLabel phoneNumber;
    JLabel insurance;
    JLabel creditCardName;
    // LabelNumberPanel cvv;
    JLabel expirationDate;
    JLabel nameOnCard;
    JLabel emergencyName;
    JLabel emergencyNumber;
    JLabel emergencyRelationship;
    final JButton returnHomePage;

    /**
     * A window with a title and a JButton.
     */
    public EditedView(EditedViewModel editedViewModel) {
        this.editedViewModel = editedViewModel;
        this.editedViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Edited Profile Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel userProfileInfo = new JLabel("Changes have been successfully saved: ");
        password = new JLabel();
        email = new JLabel();
        phoneNumber = new JLabel();
        insurance = new JLabel();
        creditCardName = new JLabel();
        // cvv = new LabelNumberPanel();
        expirationDate = new JLabel();
        nameOnCard = new JLabel();
        emergencyName = new JLabel();
        emergencyNumber = new JLabel();
        emergencyRelationship = new JLabel();


        JPanel buttons = new JPanel();
        returnHomePage = new JButton(editedViewModel.EXIT_BUTTON_LABEL);
        buttons.add(returnHomePage);

        returnHomePage.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(userProfileInfo);
        this.add(password);
        this.add(email);
        this.add(phoneNumber);
        this.add(insurance);
        this.add(creditCardName);
        // this.add(cvv);
        this.add(expirationDate);
        this.add(nameOnCard);
        this.add(emergencyName);
        this.add(emergencyNumber);
        this.add(emergencyRelationship);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditedState state = (EditedState) evt.getNewValue();
        password.setText(state.getPassword());
        email.setText(state.getEmail());
        phoneNumber.setText(state.getPhoneNumber());
        insurance.setText(state.getInsurance());
        creditCardName.setText(state.getCreditCardNumber());
        // cvv.setValue(state.getCvv());
        expirationDate.setText(state.getExpirationDate());
        nameOnCard.setText(state.getNameOnCard());
        emergencyName.setText(state.getEmergencyName());
        emergencyNumber.setText(state.getEmergencyNumber());
        emergencyRelationship.setText(state.getEmergencyRelationship());


    }
}
