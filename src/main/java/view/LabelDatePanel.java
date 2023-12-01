package view;

import javax.swing.*;

//handling input of type date
public class LabelDatePanel extends JPanel {
    LabelDatePanel(JLabel label, DateInputField date){
        this.add(label);
        this.add(date);
    }
}
