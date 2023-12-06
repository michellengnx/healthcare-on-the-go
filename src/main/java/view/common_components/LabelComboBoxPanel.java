package view.common_components;

import javax.swing.*;

/**
 * A panel containing a label and a combo box.
 */
public class LabelComboBoxPanel extends JPanel {
    public LabelComboBoxPanel(JLabel label, JComboBox comboBox) {
        this.add(label);
        this.add(comboBox);
    }
}
