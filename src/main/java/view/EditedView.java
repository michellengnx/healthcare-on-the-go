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

    JLabel username;
    JLabel password;
    JLabel insurance;
    JLabel email;
    JLabel phoneNumber;

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
        username = new JLabel();

        JPanel buttons = new JPanel();
        returnHomePage = new JButton(editedViewModel.EXIT_BUTTON_LABEL);
        buttons.add(returnHomePage);

        returnHomePage.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
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
    }
}
