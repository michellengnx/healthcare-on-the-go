package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInputField extends JPanel {
    private final JFormattedTextField dateTextField;

    DateInputField(int size) {
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            dateTextField = new JFormattedTextField(mask);
            dateTextField.setColumns(size);
            this.add(dateTextField);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Date getSelectedDate() {
        try {
            String inputDate = dateTextField.getText();
            if (inputDate.isEmpty()) {
                return null; // Return null or handle empty input based on your requirements
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            return dateFormat.parse(inputDate);

        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date", e);
        }
    }
}
