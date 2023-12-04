package view;

import interface_adapter.Login.LoginController;
import interface_adapter.Login.LoginState;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.ReturnToLock.ReturnToLockController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The LoginView class represents the view for the login screen.
 * It provides fields for username and password entry, along with login and cancel buttons.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    final JButton logIn;
    final JButton cancel;
    private final LoginController loginController;

    /**
     * Constructs a LoginView with the given LoginViewModel, LoginController, and ReturnToLockController.
     *
     * @param loginViewModel       The view model for the login screen.
     * @param controller           The controller handling login actions.
     * @param returnToLockController The controller to return to the lock screen.
     */
    public LoginView(LoginViewModel loginViewModel, LoginController controller, ReturnToLockController returnToLockController) {

        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

        JPanel buttons = new JPanel();
        cancel = new JButton(LoginViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        logIn = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);

        logIn.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            LoginState currentState = loginViewModel.getState();

                            loginController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(cancel)) {
                            returnToLockController.execute();
                        }
                    }
                }
        );

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                loginViewModel.setState(currentState);
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
                        LoginState currentState = loginViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        loginViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(new BorderLayout());

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("Welcome back to Healthcare On the Go!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel loginLabel = new JLabel("We hope you are doing well and receive your desired medical service by logging back in.");
        loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        welcomePanel.add(Box.createVerticalGlue()); // Add spacing above
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(loginLabel);
        welcomePanel.add(Box.createVerticalGlue()); // Add spacing below

        // Center align username and password fields
        JPanel inputFieldsPanel = new JPanel(new GridLayout(2, 1, 5, 5)); // Grid layout for username and password
        inputFieldsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputFieldsPanel.add(usernameInfo);
        inputFieldsPanel.add(passwordInfo);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalGlue()); // Add spacing at the top
        this.add(title);
        this.add(Box.createVerticalGlue()); // Add spacing between title and welcome message
        this.add(welcomePanel);
        this.add(Box.createVerticalGlue()); // Add spacing between welcome message and input fields
        this.add(inputFieldsPanel);
        this.add(Box.createVerticalGlue()); // Add spacing between input fields and buttons
        this.add(buttons);
        this.add(Box.createVerticalGlue()); // Add spacing at the bottom
    }

    /**
     * Handles action events from buttons.
     *
     * @param evt The event to be processed.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Handles property change events.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
    }

}