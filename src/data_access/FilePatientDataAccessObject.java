package data_access;

import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import use_case.edit_profile.EditUserDataAccessInterface;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Date;

public class FilePatientDataAccessObject implements EditUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Patient> accounts = new HashMap<>();

    public FilePatientDataAccessObject(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("gender", 2);
        headers.put("insurance", 3);
        headers.put("birthday", 4);
        headers.put("email", 5);
        headers.put("number", 6);
        headers.put("credit card", 7);
        headers.put("emergency contact", 8);
        headers.put("requests", 9);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String header = reader.readLine();

            assert header.equals("username,password,email,number,gender,insurance,birthday,credit card number,cvv,credit card expiration date,name on card,emergency contact name,emergency contact phone number,emergency contact relationship,requests");

            String row;
            while ((row = reader.readLine()) != null) {
                // does the type of credit card, birthday, emergency contact need to change?
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String password = String.valueOf(col[headers.get("password")]);
                String email = String.valueOf(col[headers.get("email")]);
                String number = String.valueOf(col[headers.get("number")]);
                String gender = String.valueOf(col[headers.get("gender")]);
                String insurance = String.valueOf(col[headers.get("insurance")]);
                String birthdate = String.valueOf(col[headers.get("birthday")]);
                String creditCardNumber = String.valueOf(col[headers.get("credit card number")]);
                int cvv = Integer.parseInt(col[headers.get("cvv")]);
                String expirationDate = String.valueOf(col[headers.get("credit card expiration date")]);
                String nameOnCard = String.valueOf(col[headers.get("name on card")]);
                String emergencyContactName = String.valueOf(col[headers.get("emergency contact name")]);
                String emergencyContactPhoneNumber = String.valueOf(col[headers.get("emergency contact phone number")]);
                String emergencyContactRelationship = String.valueOf(col[headers.get("emergency contact relationship")]);
                String requests = String.valueOf(col[headers.get("requests")]);
                Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
                CreditCard creditCard = new CreditCard(creditCardNumber, cvv, expirationDate, nameOnCard);
                EmergencyContact emergencyContact = new EmergencyContact(emergencyContactName, emergencyContactPhoneNumber, emergencyContactRelationship);
                Patient patient = new Patient(username, password, email, number, gender, insurance, birthday, creditCard, emergencyContact);
                accounts.put(username, patient);
            }
        }
    }

    public void save(Patient patient) {
        accounts.put(patient.getUsername(), patient);
        this.save();
    }

    @Override
    public Patient get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Patient patient : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s",
                        patient.getUsername(), patient.getPassword(), patient.getEmail(), patient.getPhoneNumber(),
                        patient.getGender(), patient.getInsurance(), patient.getBirthday());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier.
     */

    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    private boolean changeExists(String old, String updated) {
        return !old.equals(updated);
    }

    /**
     * Edit the patient's current username to their desired new username.
     * @param username
     * @param password verifies if the changes to the account are made by the patient themselves
     * @param newUsername
     * @return a note about whether the change has been successful or not.
     */

    // see if we can change this to an exception
    public String editUsername(String username, String password, String newUsername) {
        Patient patient = accounts.get(username);
        boolean passwordCorrect = password.equals(patient.getPassword());
        boolean usernameOccupied = existsByName(newUsername);
        if (!usernameOccupied && passwordCorrect) {
            patient.setUsername(newUsername);
            save();
            return "Username successfully changed to " + newUsername + "!";
        } else if (usernameOccupied) {
            return newUsername + "is already used by a different user. Please choose a different username.";
        }
        // if there is no change between the usernames, the usernameOccupied would have caught it.
        // Therefore, no need for changeExists function.
        return "Password is incorrect. Please try again.";
    }

    public String editPassword(String username, String password, String newPassword) {
        Patient patient = accounts.get(username);
        boolean changeExists = changeExists(password, newPassword);
        boolean passwordCorrect = password.equals(patient.getPassword());
        if (changeExists && passwordCorrect) {
            patient.setPassword(newPassword);
            save();
            return "Password has successfully been changed!";
        }
        return "Password is incorrect. Please try again.";
    }

    public String editInsurance(String username, String password, String newInsurance) {
        Patient patient = accounts.get(username);
        boolean changeExists = changeExists(patient.getInsurance(), newInsurance);
        boolean passwordCorrect = password.equals(patient.getPassword());
        if (changeExists && passwordCorrect) {
            patient.setInsurance(newInsurance);
            save();
            return "Your insurance has successfully been changed!";
        } else if (!passwordCorrect) {
            return "Password is incorrect. Please try again.";
        }
        return "New insurance inputted is the same as the old one previously stored. Please try again.";
    }

    public String editEmail(String username, String password, String newEmail) {
        Patient patient = accounts.get(username);
        boolean changeExists = changeExists(patient.getEmail(), newEmail);
        boolean passwordCorrect = password.equals(patient.getPassword());
        if (changeExists && passwordCorrect) {
            patient.setEmail(newEmail);
            save();
            return "Your email has been successfully changed to " + newEmail + "!";
        } else if (!passwordCorrect) {
            return "Password is incorrect. Please try again.";
        }
        return "New email inputted is the same as the old email previously stored. Please try again.";
    }

    public String editPhoneNumber(String username, String password, String newPhoneNumber) {
        Patient patient = accounts.get(username);
        boolean changeExists = changeExists(patient.getPhoneNumber(), newPhoneNumber);
        boolean passwordCorrect = password.equals(patient.getPassword());
        if (changeExists) {
            patient.setPhoneNumber(newPhoneNumber);
            save();
            return "Your phone number has been successfully changed to " + newPhoneNumber + "!";
        } else if (!passwordCorrect) {
            return "Password is incorrect. Please try again.";
        }
        return "New phone number inputted is the same as the old one previously stored. Please try again.";
    }

    // for view model, show the whole profile instead of the change
    // new view^
}

