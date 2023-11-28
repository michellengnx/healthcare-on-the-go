package view;

import interface_adapter.SignUp.SignUpController;
import interface_adapter.SignUp.SignUpState;
import interface_adapter.SignUp.SignUpViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

public class SignUpView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignUpViewModel signUpViewModel;
    private final SignUpController signUpController;

//    form
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final JTextField emailInputField = new JTextField(15);
    private final JTextField phoneNumberInputField = new JTextField(15);
    private final JTextField genderInputField = new JTextField(15);
    private final JTextField insuranceInputField = new JTextField(15);

    private final DateInputField birthdayInputField = new DateInputField(); // You should initialize this according to your requirements
    private final JTextField creditCardNumberInputField = new JTextField(15);
    private final JTextField contactNameInputField = new JTextField(15);
    private final JTextField contactPhoneNumberInputField = new JTextField(15);
    private final JTextField contactRelationshipInputField = new JTextField(15);

    private final JFormattedTextField ccvInputField = new JFormattedTextField(); // You should initialize this according to your requirements
    private final JTextField expirationDateInputField = new JTextField(15);
    private final JTextField nameOnCardInputField = new JTextField(15);

//    button
    private final JButton signUp;
    private final JButton cancel;

    public SignUpView(SignUpController signUpController, SignUpViewModel signUpViewModel) {

        this.signUpController = signUpController;
        this.signUpViewModel = signUpViewModel;
        signUpViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(SignUpViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


// name + text field
        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.EMAIL_LABEL), emailInputField);
        LabelTextPanel phoneNumberInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.PHONE_NUMBER_LABEL), phoneNumberInputField);
        LabelTextPanel genderInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.GENDER_LABEL), genderInputField);
        LabelTextPanel insuranceInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.INSURANCE_LABEL), insuranceInputField);

        LabelDatePanel birthdayInfo = new LabelDatePanel(
                new JLabel(SignUpViewModel.BIRTHDAY_LABEL), birthdayInputField); // Assuming Date.toString() is sufficient
        LabelTextPanel creditCardNumberInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.CREDIT_CARD_NUMBER_LABEL), creditCardNumberInputField);
        LabelTextPanel contactNameInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.CONTACT_NAME_LABEL), contactNameInputField);
        LabelTextPanel contactPhoneNumberInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.CONTACT_PHONE_NUMBER_LABEL), contactPhoneNumberInputField);
        LabelTextPanel contactRelationshipInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.CONTACT_RELATIONSHIP_LABEL), contactRelationshipInputField);

        LabelNumberPanel ccvInfo = new LabelNumberPanel(
                new JLabel(SignUpViewModel.CCV_LABEL), ccvInputField);
        LabelTextPanel expirationDateInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.EXPIRATION_DATE_LABEL), expirationDateInputField);
        LabelTextPanel nameOnCardInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.NAME_ON_CARD_LABEL), nameOnCardInputField);


        JPanel buttons = new JPanel();
        signUp = new JButton(SignUpViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        cancel = new JButton(SignUpViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        signUp.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            SignUpState currentState = signUpViewModel.getState();

                            signUpController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword(),
                                    currentState.getEmail(),
                                    currentState.getPhoneNumber(),
                                    currentState.getGender(),
                                    currentState.getInsurance(),
                                    currentState.getBirthday(),
                                    currentState.getCreditCardNumber(),
                            currentState.getCcv(),
                            currentState.getExpirationDate(),
                            currentState.getNameOnCard(),
                            currentState.getContactName(),
                            currentState.getContactPhoneNumber(),
                            currentState.getContactRelationship()

                            );
                        }
                    }
                }
        );

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignUpState currentState = signUpViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        signUpViewModel.setState(currentState);
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
                        SignUpState currentState = signUpViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        signUpViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignUpState currentState = signUpViewModel.getState();
                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
                        signUpViewModel.setState(currentState); // Hmm, is this necessary?
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
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(emailInfo);
        this.add(phoneNumberInfo);
        this.add(genderInfo);
        this.add(insuranceInfo);
        this.add(birthdayInfo);
        this.add(creditCardNumberInfo);
        this.add(contactNameInfo);
        this.add(contactPhoneNumberInfo);
        this.add(contactRelationshipInfo);
        this.add(ccvInfo);
        this.add(expirationDateInfo);
        this.add(nameOnCardInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();

        if (propertyName.equals("signup")) {
            SignUpState state = (SignUpState) evt.getNewValue();
            System.out.println(state);
            if (state.getUsernameError() != null) {
                JOptionPane.showMessageDialog(this, state.getUsernameError());
            }
        }

        }
    }
