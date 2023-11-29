package view;

import interface_adapter.SignUp.SignUpController;
import interface_adapter.SignUp.SignUpViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
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

    private final DateInputField birthdayInputField = new DateInputField(15); // You should initialize this according to your requirements
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
        title.setAlignmentX(Component.LEFT_ALIGNMENT);


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
                new JLabel(SignUpViewModel.CCV_LABEL), ccvInputField, 15);
        LabelTextPanel expirationDateInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.EXPIRATION_DATE_LABEL), expirationDateInputField);
        LabelTextPanel nameOnCardInfo = new LabelTextPanel(
                new JLabel(SignUpViewModel.NAME_ON_CARD_LABEL), nameOnCardInputField);


        JPanel buttons = new JPanel();
        signUp = new JButton(SignUpViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        cancel = new JButton(SignUpViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        signUp.addActionListener(evt -> {
            // Get input values from the fields
            String username = usernameInputField.getText();
            String password = Arrays.toString(passwordInputField.getPassword());
            String repeatPassword = Arrays.toString(repeatPasswordInputField.getPassword());
            String email = emailInputField.getText();
            String phoneNumber = phoneNumberInputField.getText();
            String gender = genderInputField.getText();
            String insurance = insuranceInputField.getText();
            Date birthday = birthdayInputField.getSelectedDate(); // Assuming you have a method to get the selected date
            String creditCardNumber = creditCardNumberInputField.getText();
            String contactName = contactNameInputField.getText();
            String contactPhoneNumber = contactPhoneNumberInputField.getText();
            String contactRelationship = contactRelationshipInputField.getText();
            int ccv = Integer.parseInt(ccvInputField.getText()); // Assuming ccvInputField contains a numeric value
            String expirationDate = expirationDateInputField.getText();
            String nameOnCard = nameOnCardInputField.getText();

            // Call the execute method with the input values
            signUpController.execute(
                    username, password, repeatPassword, email, phoneNumber, gender, insurance,
                    birthday, creditCardNumber, ccv, contactPhoneNumber, contactRelationship,
                    contactName, expirationDate, nameOnCard
            );
        });


        cancel.addActionListener(evt -> System.exit(0));

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
        JOptionPane.showConfirmDialog(this, "Invalid action");
    }


    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
