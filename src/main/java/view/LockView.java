package view;

import data_access.FilePatientDataAccessObject;
import interface_adapter.LockView.LockController;
import interface_adapter.LockView.LockViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.ParseException;

/**
 * The LockView class represents the view for the lock screen.
 * It provides options for users to log in or sign up.
 */
public class LockView extends JPanel implements ActionListener, PropertyChangeListener {
    public String viewName = "lock";
    private JPanel buttonPanel;
    private final String patientDataPath = "data/patients.csv";
    private JButton login;
    private JButton signup;
    private JPanel labelPanel;
    private JLabel welcome;
    private JLabel appInfo;
    private JLabel buttonInfo;
    private LockViewModel lockViewModel;

    /**
     * Constructs the LockView with the given LockViewModel and LockController.
     *
     * @param lockViewModel  The view model for the lock screen.
     * @param lockController The controller for handling lock screen actions.
     */
    public LockView(LockViewModel lockViewModel, LockController lockController){
        this.lockViewModel = lockViewModel;
        this.login = new JButton(lockViewModel.LOGIN_BUTTON_LABEL);
        this.signup = new JButton(lockViewModel.SIGNUP_BUTTON_LABEL);
        this.buttonPanel = new JPanel(new FlowLayout());
        this.labelPanel = new JPanel(new FlowLayout());
        this.setSize(800,600);
        this.login.addActionListener(this);
        this.signup.addActionListener(this);

        signup.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(signup)) {
                            lockController.execute("sign up");
                        }
                    }
                }
        );

        login.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(login)) {
                            lockController.execute("log in");
                        }
                    }
                }
        );

        this.setLayout(new BorderLayout());

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.setBorder(new EmptyBorder(100, 0, 100, 0));

        JLabel welcome = new JLabel("Welcome to Healthcare On the Go!");
        welcome.setFont(new Font("Arial", Font.BOLD, 25));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPanel.add(welcome);

        // Add space between welcome and appInfo labels
        labelPanel.add(Box.createVerticalStrut(20));

        JLabel appInfo = new JLabel("<html>Your go-to ride-hailing app to get accessible healthcare "
                + "<br>right at the comfort of your home &#x1F3E5;</html>");
        appInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        appInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        appInfo.setHorizontalAlignment(SwingConstants.CENTER); // Align center horizontally
        labelPanel.add(appInfo);

        // Add space between appInfo and buttonInfo labels
        labelPanel.add(Box.createVerticalStrut(20));

        JLabel buttonInfo = new JLabel("If you already have an account, please login. If not, please sign up");
        buttonInfo.setFont(new Font("Tahoma", Font.ITALIC, 12)); // Suggested font: Tahoma
        buttonInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonInfo.setHorizontalAlignment(SwingConstants.CENTER); // Align center horizontally
        labelPanel.add(buttonInfo);

        this.add(labelPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 20, 0)); // Adjust top and bottom margins as needed
        buttonPanel.add(signup);
        buttonPanel.add(login);

        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    /**
     * Handles action events from buttons.
     *
     * @param e The event to be processed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }


    /**
     * Main method to demonstrate the LockView functionality.
     *
     * @param args Command-line arguments.
     * @throws IOException    Signals that an I/O exception has occurred.
     * @throws ParseException Signals that a parse exception has occurred.
     */
    public static void main(String[] args) throws IOException, ParseException {
        FilePatientDataAccessObject filePatientDataAccessObject = new FilePatientDataAccessObject("data/patients.csv");

    }

    /**
     * Handles property change events.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
