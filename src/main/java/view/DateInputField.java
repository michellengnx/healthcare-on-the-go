package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class DateInputField extends JPanel {
    DateInputField() {
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            JFormattedTextField dateTextField = new JFormattedTextField(mask);
            this.add(dateTextField);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
