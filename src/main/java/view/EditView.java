package view;

import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.edit_profile.EditController;
import interface_adapter.edit_profile.EditState;
import interface_adapter.edit_profile.EditViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Represents the view for editing a user profile.
 */
public class EditView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "edit";
    private final EditViewModel editViewModel;

    final JTextField usernameInputField = new JTextField(15);

    final JPasswordField passwordInputField = new JPasswordField(15);

    final JTextField emailInputField = new JTextField(15);

    final JTextField phoneNumberInputField = new JTextField(15);

    final JTextField insuranceInputField = new JTextField(15);

    final JTextField creditCardNumberInputField = new JTextField(15);

    final JFormattedTextField cvvInputField = new JFormattedTextField();


    final JTextField expirationDateInputField = new JTextField(10);

    final JTextField nameOnCardInputField = new JTextField(15);

    final JTextField emergencyNameInputField = new JTextField(15);

    final JTextField emergencyNumberInputField = new JTextField(15);

    final JTextField emergencyRelationshipInputField = new JTextField(15);

    final JButton editProfile;
    final JButton cancel;
    private final EditController editController;

    private final JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");

    /**
     * Constructs an EditView object.
     *
     * @param editViewModel the view model associated with the edit profile view.
     * @param controller the controller handling edit profile actions.
     */
    public EditView(EditViewModel editViewModel, EditController controller, ReturnHomeController returnHomeController) {

        this.editController = controller;
        this.editViewModel = editViewModel;
        this.editViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(EditViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subheading_main = new JLabel(EditViewModel.SUBHEADING_MAIN_LABEL);
        subheading_main.setFont(new Font("Arial", Font.BOLD, 14));
        subheading_main.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subheading_card = new JLabel(EditViewModel.SUBHEADING_CREDIT_CARD_LABEL);
        subheading_card.setFont(new Font("Arial", Font.BOLD, 14));
        subheading_card.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subheading_emergency = new JLabel(EditViewModel.SUBHEADING_EMERGENCY_CONTACT_LABEL);
        subheading_emergency.setFont(new Font("Arial", Font.BOLD, 14));
        subheading_emergency.setAlignmentX(Component.CENTER_ALIGNMENT);


        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_PASSWORD_LABEL), passwordInputField);
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_EMAIL_LABEL), emailInputField);
        LabelTextPanel phoneNumberInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_PHONE_NUMBER_LABEL), phoneNumberInputField);
        LabelTextPanel insuranceInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_INSURANCE_LABEL), insuranceInputField);
        LabelTextPanel creditCardNumberInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_CREDIT_CARD_NUMBER_LABEL), creditCardNumberInputField);
        LabelNumberPanel cvvInfo = new LabelNumberPanel(
                new JLabel(EditViewModel.NEW_CVV_LABEL), cvvInputField, 15);
        LabelTextPanel expirationDateInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_EXPIRATION_DATE_LABEL), expirationDateInputField);
        LabelTextPanel nameOnCardInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_NAME_ON_CARD_LABEL), nameOnCardInputField);
        LabelTextPanel emergencyNameInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_EMERGENCY_NAME_LABEL), emergencyNameInputField);
        LabelTextPanel emergencyNumberInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_EMERGENCY_NUMBER_LABEL), emergencyNumberInputField);
        LabelTextPanel emergencyRelationshipInfo = new LabelTextPanel(
                new JLabel(EditViewModel.NEW_EMERGENCY_RELATIONSHIP_LABEL), emergencyRelationshipInputField);

        JPanel buttons = new JPanel();
        cancel = new JButton(EditViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        editProfile = new JButton(EditViewModel.EDIT_PROFILE_BUTTON_LABEL);
        buttons.add(editProfile);

        editProfile.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(editProfile)) {
                            EditState currentState = editViewModel.getState();

                            editController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getEmail(),
                                    currentState.getPhoneNumber(),
                                    currentState.getInsurance(),
                                    currentState.getCreditCardNumber(),
                                    currentState.getCvv(),
                                    currentState.getExpirationDate(),
                                    currentState.getNameOnCard(),
                                    currentState.getEmergencyName(),
                                    currentState.getEmergencyNumber(),
                                    currentState.getEmergencyRelationship()
                            );
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        returnHomeController.execute();
                    }
                }
        );

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                EditState currentState = editViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                editViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setPassword(new String(passwordInputField.getPassword()) + e.getKeyChar());
                        editViewModel.setState(currentState);
                        System.out.println(new String(passwordInputField.getPassword()) + e.getKeyChar());
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        showPasswordCheckBox.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Toggle the visibility of password characters
                        if (showPasswordCheckBox.isSelected()) {
                            passwordInputField.setEchoChar((char) 0); // Show characters
                        } else {
                            passwordInputField.setEchoChar('*'); // Hide characters
                        }
                    }
                }
        );

        // Password panel that includes the password field and the show/hide checkbox
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordInfo);
        passwordPanel.add(showPasswordCheckBox);

        emailInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setEmail(emailInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        phoneNumberInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setPhoneNumber(phoneNumberInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        insuranceInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setInsurance(insuranceInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        JPanel mainPanel = new JPanel(new GridLayout(5, 1));
        mainPanel.add(usernameInfo);
        mainPanel.add(passwordPanel);
        mainPanel.add(emailInfo);
        mainPanel.add(phoneNumberInfo);
        mainPanel.add(insuranceInfo);

        creditCardNumberInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setCreditCardNumber(creditCardNumberInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        cvvInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setCvv(Integer.valueOf(cvvInputField.getText() + e.getKeyChar()));
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        // change to date package
        expirationDateInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setExpirationDate(expirationDateInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        nameOnCardInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setNameOnCard(nameOnCardInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        JPanel creditCardPanel = new JPanel(new GridLayout(4, 1));
        creditCardPanel.add(creditCardNumberInfo);
        creditCardPanel.add(cvvInfo);
        creditCardPanel.add(expirationDateInfo);
        creditCardPanel.add(nameOnCardInfo);

        emergencyNameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setEmergencyName(emergencyNameInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        emergencyNumberInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setEmergencyNumber(emergencyNumberInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        emergencyRelationshipInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        currentState.setEmergencyRelationship(emergencyRelationshipInputField.getText() + e.getKeyChar());
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        JPanel emergencyPanel = new JPanel(new GridLayout(3, 1));
        emergencyPanel.add(emergencyNameInfo);
        emergencyPanel.add(emergencyNumberInfo);
        emergencyPanel.add(emergencyRelationshipInfo);



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(new JSeparator(SwingConstants.HORIZONTAL));
        this.add(subheading_main);
        this.add(mainPanel);
        this.add(new JSeparator(SwingConstants.HORIZONTAL));
        this.add(subheading_card);
        this.add(creditCardPanel);
        this.add(new JSeparator(SwingConstants.HORIZONTAL));
        this.add(subheading_emergency);
        this.add(emergencyPanel);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        //check where the event is coming from - if statements
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Handles changes in the property.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditState state = (EditState) evt.getNewValue();

        // pre-populate input fields
        setFields(state);

       // if (state.getUsernameError() != null) {
        //    JOptionPane.showMessageDialog(this, state.getUsernameError());
      //  }
        if (state.getPasswordError() != null) {
            JOptionPane.showMessageDialog(this, state.getPasswordError());
        }
    }

    /**
     * Sets the input fields based on the state data.
     *
     * @param state The state containing user profile information.
     */
    private void setFields(EditState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField.setText(state.getPassword());
        emailInputField.setText(state.getEmail());
        phoneNumberInputField.setText(state.getPhoneNumber());
        insuranceInputField.setText(state.getInsurance());
        creditCardNumberInputField.setText(state.getCreditCardNumber());
        cvvInputField.setText(String.valueOf(state.getCvv()));
        expirationDateInputField.setText(state.getExpirationDate());
        nameOnCardInputField.setText(state.getNameOnCard());
        emergencyNameInputField.setText(state.getEmergencyName());
        emergencyNumberInputField.setText(state.getEmergencyNumber());
        emergencyRelationshipInputField.setText(state.getEmergencyRelationship());
    }
}
