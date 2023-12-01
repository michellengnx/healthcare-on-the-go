package view;

import app.SignUpUseCaseFactory;
import data_access.FilePatientDataAccessObject;
import interface_adapter.SignUp.SignUpController;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import use_case.SignUp.SignUpInputData;
import use_case.SignUp.SignUpInteractor;
import use_case.SignUp.SignUpOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class LockView extends JFrame implements ActionListener {
    private JPanel buttonPanel;
    private final String patientDataPath = "/Users/ismaelchona/IdeaProject/csc207-project/src/main/java/data/patients.csv";
    private JButton login;
    private JButton signup;
    private JPanel labelPanel;
    private JLabel welcome;
    public LockView(){
        this.login = new JButton("login");
        this.signup = new JButton("signup");
        this.buttonPanel = new JPanel(new FlowLayout());
        this.labelPanel = new JPanel(new FlowLayout());
        this.setSize(800,600);
        this.login.addActionListener(this);
        this.signup.addActionListener(this);
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
        new LockView();

    }
}
