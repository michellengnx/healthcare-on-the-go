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

    // where does 15 come from?
    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    final JTextField emailInputField = new JTextField(15);
    private final JLabel emailErrorField = new JLabel();

    final JTextField phoneNumberInputField = new JTextField(15);
    private final JLabel phoneNumberErrorField = new JLabel();

    final JTextField insuranceInputField = new JTextField(15);
    private final JLabel insuranceErrorField = new JLabel();

    final JButton editProfile;
    final JButton cancel;
    private final JButton clear;
    private final EditController editController;

    public EditView(EditViewModel editViewModel, EditController controller) {

        this.editController = controller;
        this.editViewModel = editViewModel;
        this.editViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Edit Profile Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel("Email"), emailInputField);
        LabelTextPanel phoneNumberInfo = new LabelTextPanel(
                new JLabel("Phone Number"), phoneNumberInputField);
        LabelTextPanel insuranceInfo = new LabelTextPanel(
                new JLabel("Insurance"), insuranceInputField);

        JPanel buttons = new JPanel();
        editProfile = new JButton(editViewModel.EDIT_PROFILE_BUTTON_LABEL);
        buttons.add(editProfile);
        cancel = new JButton(editViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        clear = new JButton(editViewModel.CLEAR_BUTTON_LABEL);

        editProfile.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(editProfile)) {
                            EditState currentState = editViewModel.getState();

                            editController.execute(
                                    currentState.getUsername(),
                                    currentState.getNewUsername(),
                                    currentState.getNewPassword(),
                                    currentState.getNewInsurance(),
                                    currentState.getNewEmail(),
                                    currentState.getNewPhoneNumber()
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
                currentState.setUsername(usernameInputField.getText() +e.getKeyChar());
                editViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditState currentState = editViewModel.getState();
                        // ask
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

        this.add(title);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(passwordErrorField);
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
        EditState state = (EditState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(EditState state) {
        usernameInputField.setText(state.getUsername());
    }

}
