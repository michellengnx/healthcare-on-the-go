package view;

import javax.swing.*;

class LabelNumberPanel extends JPanel {
    LabelNumberPanel(JLabel label, JFormattedTextField formattedTextField) {
        this.add(label);
        this.add(formattedTextField);
    }
}
