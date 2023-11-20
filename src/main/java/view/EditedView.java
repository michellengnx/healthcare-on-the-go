package view;

import interface_adapter.edited_profile.EditedState;
import interface_adapter.edited_profile.EditedViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditedView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "edited";
    private final EditedViewModel editedViewModel;
    // should other buttons be here? aim: show the profile after changes have been made
    JLabel username;
    JLabel password;
    JLabel email;
    JLabel phoneNumber;
    JLabel insurance;
    final JButton returnHomePage;

    /**
     * A window with a title and a JButton.
     */
    public EditedView(EditedViewModel editedViewModel) {
        this.editedViewModel = editedViewModel;
        this.editedViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Edited Profile Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Changes have been successfully saved: ");
        // should these buttons be here?
        username = new JLabel();
        password = new JLabel();
        email = new JLabel();
        phoneNumber = new JLabel();
        insurance = new JLabel();

        JPanel buttons = new JPanel();
        returnHomePage = new JButton(editedViewModel.EXIT_BUTTON_LABEL);
        buttons.add(returnHomePage);

        returnHomePage.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo); // should this be called username info?
        this.add(username); // buttons should be here?
        this.add(password);
        this.add(email);
        this.add(phoneNumber);
        this.add(insurance);
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
        EditedState state = (EditedState) evt.getNewValue();
        username.setText(state.getUsername());
        // should I add the other parameters here too?
    }
}
