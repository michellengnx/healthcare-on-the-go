package view;

import data_access.FilePatientDataAccessObject;
import interface_adapter.LockView.LockController;
import interface_adapter.LockView.LockViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.ParseException;

public class LockView extends JPanel implements ActionListener, PropertyChangeListener {
    public String viewName = "lock";
    private JPanel buttonPanel;
    private final String patientDataPath = "/Users/ismaelchona/IdeaProject/csc207-project/src/main/java/data/patients.csv";
    private JButton login;
    private JButton signup;
    private JPanel labelPanel;
    private JLabel welcome;
    private LockViewModel lockViewModel;
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

        this.buttonPanel.add(signup);
        this.buttonPanel.add(login);
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.welcome = new JLabel("Welcome to Health care on the go! If you already have an account please login. If not please signup.");
        this.labelPanel.add(welcome);
        this.add(welcome, BorderLayout.CENTER);
        this.setVisible(true);
    }


    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) throws IOException, ParseException {
        FilePatientDataAccessObject filePatientDataAccessObject = new FilePatientDataAccessObject("/data/patinets.csv");

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
