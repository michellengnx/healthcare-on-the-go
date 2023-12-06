package view;

import app.App;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ViewRequestsViewTest {

    public ViewRequestsView getView() {
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

        return (ViewRequestsView) jp2.getComponent(4);
    }

//    this one gets the table
    public JTable getTable() {
        ViewRequestsView viewRequestsView = getView();
        JScrollPane jsp = (JScrollPane) viewRequestsView.getComponent(0);
        return (JTable) jsp.getViewport().getView();

    }

    @Test
    public void testTablePresent() throws IOException {
        App.main(null);
        JTable table = getTable();
        assertEquals (table.getColumnName(0),"UserName");
    }


    @Test
    public void testViewRequestButtonFunctionality() throws IOException {
//        App.main(null);
//        JButton button = getButton();
//
//        // since clicking the button should end up displaying a JDialog to the user to report the
//        // result, we set a timer, which will execute code necessary to complete the testing.
//        createCloseTimer().start();
//
//        button.doClick();

        // will continue execution here after the JDialog is closed

        // users.csv format
        //username, password,timestamp (in format returned by a call like LocalDateTime.now())
        //example
        //user1,pass1,2023-10-12T14:46:26.733518

        //check the users.csv file to ensure the users are gone
//        try {
//            int lines = countLines();
//            System.out.println("lines left = " + lines);
//            assert(lines <= 1);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        App.main(null);
//        JButton button = getButton(1);
//        assertEquals (button.getText(),"Sign up");
    }





}
