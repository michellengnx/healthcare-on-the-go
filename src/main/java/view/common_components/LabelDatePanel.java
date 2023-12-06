package view.common_components;

import javax.swing.*;

/**
 * Represents a panel that pairs a label with a DateInputField for handling date input.
 */
//handling input of type date
public class LabelDatePanel extends JPanel {

    /**
     * Constructs a LabelDatePanel with the provided label and DateInputField.
     *
     * @param label The label component.
     * @param date  The DateInputField component.
     */
    public LabelDatePanel(JLabel label, DateInputField date){
        this.add(label);
        this.add(date);
    }
}
