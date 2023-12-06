package view.common_components;

import javax.swing.*;

public class LabelNumberPanel extends JPanel {
    public LabelNumberPanel(JLabel label, JFormattedTextField formattedTextField, int size) {
        formattedTextField.setColumns(size);
        this.add(label);
        this.add(formattedTextField);
    }
}
