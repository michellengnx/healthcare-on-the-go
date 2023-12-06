package view;


import app.App;
import data_access.FilePatientDataAccessObject;
import entities.factories.user.PatientUserFactory;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class SignUpViewTest {

    public void addUser() {
        PatientUserFactory pf = new PatientUserFactory();
        FilePatientDataAccessObject fpdao;
        try {
            fpdao = new FilePatientDataAccessObject("data/patient.csv");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        // Sample data for testing
        String username = "testUser";
        String password = "testPassword";
        String email = "test@example.com";
        String phoneNumber = "123-456-7890";
        String gender = "Male";
        String insurance = "Health Insurance";
        Date birthday = new Date();

        String creditCardNumber = "1111222233334444";
        int ccv = 123;
        String expirationDate = "12/24";
        String nameOnCard = "Cardholder";

        String contactName = "Emergency Contact";
        String contactPhoneNumber = "987-654-3210";
        String contactRelationship = "Family";

        fpdao.save(
                pf.create(
                username, password, email, phoneNumber, gender, insurance, birthday,
                creditCardNumber, ccv, expirationDate, nameOnCard,
                contactName, contactPhoneNumber, contactRelationship)
        );
    }


    public SignUpView getView() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            System.out.print(window);
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        return (SignUpView) jp2.getComponent(0);
    }

    public JButton getButton(int nth) {
        SignUpView signUpView = getView();

        JPanel buttonPanel = (JPanel)signUpView.getComponent(10);
// 0 - cancel, 1 - signup
        return (JButton) buttonPanel.getComponent(nth);
    }

    /**
     * Test that the Create Request button is present and where it is expected to be
     */

    @Test
    public void testSignUpButtonPresent() throws IOException {
        App.main(null);
        JButton button = getButton(1);
        assertEquals (button.getText(),"Sign up");
    }

    /**
     * Test that the Cancel button is present and where it is expected to be
     */

    @Test
    public void testCancelButtonPresent() throws IOException {
        App.main(null);
        JButton button = getButton(0);
        assertEquals (button.getText(),"Cancel");
    }
}