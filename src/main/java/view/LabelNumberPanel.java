package view;

import javax.swing.*;

/**
 * Represents a panel that pairs a label with a formatted text field for number input.
 */
class LabelNumberPanel extends JPanel {

    /**
     * Constructs a LabelNumberPanel with the provided label, formatted text field, and size.
     *
     * @param label              The label component.
     * @param formattedTextField The formatted text field component.
     * @param size               The number of columns for the formatted text field.
     */
    LabelNumberPanel(JLabel label, JFormattedTextField formattedTextField, int size) {
        formattedTextField.setColumns(size);
        this.add(label);
        this.add(formattedTextField);
    }
}
