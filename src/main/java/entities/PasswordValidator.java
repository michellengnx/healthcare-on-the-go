package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    List<String> patterns;
    public PasswordValidator() {
        patterns = new ArrayList<>();
    }

    public void addPattern(String pattern) {
        patterns.add(pattern);
    }

    public boolean validatePassword(String password) {


        if (password == null) {
            return false;
        }

        for (String pattern : this.patterns) {
            Pattern p = Pattern.compile(pattern);

            // Pattern class contains matcher() method
            // to find matching between given password
            // and regular expression.
            Matcher m = p.matcher(password);
            if (!m.matches()) {
                System.out.println(pattern + password);
                return false;
            }
        }

        return true;
    }
}
