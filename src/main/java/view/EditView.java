package view;

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

public class EditView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "edit";
    private final EditViewModel editViewModel;

    final JTextField usernameInputField = new JTextField(15);

    final JPasswordField passwordInputField = new JPasswordField(15);

    final JTextField emailInputField = new JTextField(15);

    /** 10-digit Canadian phone number */
    final JTextField phoneNumberInputField = new JTextField(15);

    final JTextField insuranceInputField = new JTextField(15);

    final JTextField creditCardNumberInputField = new JTextField(15);

    final JFormattedTextField cvvInputField = new JFormattedTextField(3);

    final JTextField expirationDateInputField = new JTextField(4);

    final JTextField nameOnCardInputField = new JTextField(15);

    final JTextField emergencyNameInputField = new JTextField(15);

    final JTextField emergencyNumberInputField = new JTextField(15);

    final JTextField emergencyRelationshipInputField = new JTextField(15);

    final JButton editProfile;
    final JButton cancel;
    private final EditController editController;

    private final JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");

    public EditView(EditViewModel editViewModel, EditController controller) {

        this.editController = controller;
        this.editViewModel = editViewModel;
        this.editViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(EditViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

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
                new JLabel(EditViewModel.NEW_CVV_LABEL), cvvInputField);
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
        editProfile = new JButton(EditViewModel.EDIT_PROFILE_BUTTON_LABEL);
        buttons.add(editProfile);
        cancel = new JButton(EditViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        // pre-populates text fields with the patient's current profile details
        EditState editState = editViewModel.getState();
        usernameInputField.setText(editState.getUsername());
        passwordInputField.setText(editState.getPassword());
        emailInputField.setText(editState.getEmail());
        phoneNumberInputField.setText(editState.getPhoneNumber());
        insuranceInputField.setText(editState.getInsurance());
        creditCardNumberInputField.setText(editState.getCreditCardNumber());
        cvvInputField.setValue(editState.getCvv());
        expirationDateInputField.setText(editState.getExpirationDate());
        nameOnCardInputField.setText(editState.getNameOnCard());
        emergencyNameInputField.setText(editState.getEmergencyName());
        emergencyNumberInputField.setText(editState.getEmergencyNumber());
        emergencyRelationshipInputField.setText(editState.getEmergencyRelationship());

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

        cancel.addActionListener(this);

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
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
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
        JPanel passwordPanel = new JPanel(new GridLayout(1, 2));
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



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordPanel);
        this.add(emailInfo);
        this.add(phoneNumberInfo);
        this.add(insuranceInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        //check where the event is coming from - if statements
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditState state = (EditState) evt.getNewValue();
        setFields(state);
    }
// @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        SignupState state = (SignupState) evt.getNewValue();
//        if (state.getUsernameError() != null) {
//            JOptionPane.showMessageDialog(this, state.getUsernameError());
//        }
//    }
    private void setFields(EditState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField.setText(state.getPassword());
        emailInputField.setText(state.getEmail());
        phoneNumberInputField.setText(state.getPhoneNumber());
        insuranceInputField.setText(state.getInsurance());

    }
}
