package view;

import javax.swing.*;

class LabelNumberPanel extends JPanel {
    LabelNumberPanel(JLabel label, JFormattedTextField formattedTextField, int size) {
        formattedTextField.setColumns(size);
        this.add(label);
        this.add(formattedTextField);
    }
}