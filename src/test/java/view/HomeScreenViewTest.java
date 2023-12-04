package view;


import app.App;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class HomeScreenViewTest {


    /**
     * ensures there are at least 2 users in the CSV file for testing purposes
     */

    public HomeScreenView getView() {
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

        return (HomeScreenView) jp2.getComponent(2);
    }

    public JButton getButton(int nth) {
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

        HomeScreenView homeScreenView = (HomeScreenView) jp2.getComponent(2);

        JPanel buttonPanel = (JPanel) homeScreenView.getComponent(2);
// 0 - signup, 1 - login
        return (JButton) buttonPanel.getComponent(nth);
    }

    /**
     * Test that the Create Request button is present and where it is expected to be
     */
    @Test
    public void testCreateRequestButtonPresent() throws IOException {
        App.main(null);
        JButton button = getButton(0);
        assert (button.getText().equals("Create Request"));
    }

    /**
     * Test that the View Requests button is present and where it is expected to be
     */
    @Test
    public void testViewRequestsButtonPresent() throws IOException {
        App.main(null);
        JButton button = getButton(1);
        assert (button.getText().equals("View Requests"));
    }




}