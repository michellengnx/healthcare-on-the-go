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

    final JTextField emailInputField = new JTextField(25);

    /** 11-digit Canadian phone number */
    final JTextField phoneNumberInputField = new JTextField(11);

    final JTextField insuranceInputField = new JTextField(30);

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
                                    currentState.getInsurance()
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
        JPanel passwordPanel = new JPanel(new GridLayout(2, 1));
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

    private void setFields(EditState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField.setText(state.getPassword());
        emailInputField.setText(state.getEmail());
        phoneNumberInputField.setText(state.getPhoneNumber());
        insuranceInputField.setText(state.getInsurance());
    }
}
