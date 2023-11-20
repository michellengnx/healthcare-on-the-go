package data_access;

import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import use_case.edit_profile.EditUserDataAccessInterface;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// add implements SignupUserDataAccessInterface, LoginUserDataAccessInterface
public class FilePatientDataAccessObject implements EditUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Patient> accounts = new HashMap<>();

    public FilePatientDataAccessObject(String csvPath) throws IOException, ParseException {
        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("email", 2);
        headers.put("phone number", 3);
        headers.put("gender", 4);
        headers.put("insurance", 5);
        headers.put("birthday", 6);
        headers.put("credit card number", 7);
        headers.put("cvv", 8);
        headers.put("credit card expiration date", 9);
        headers.put("name on card", 10);
        headers.put("emergency contact name", 11);
        headers.put("emergency contact phone number", 12);
        headers.put("emergency contact relationship", 13);
        headers.put("requests", 14);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                assert header.equals("username,password,email,phone number,gender,insurance,birthday,credit card number,cvv,credit card expiration date,name on card,emergency contact name,emergency contact phone number,emergency contact relationship,requests");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String email = String.valueOf(col[headers.get("email")]);
                    String number = String.valueOf(col[headers.get("phone number")]);
                    String gender = String.valueOf(col[headers.get("gender")]);
                    String insurance = String.valueOf(col[headers.get("insurance")]);
                    Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(col[headers.get("birthday")]));
                    String creditCardNumber = String.valueOf(col[headers.get("credit card number")]);
                    int cvv = Integer.parseInt(col[headers.get("cvv")]);
                    String expirationDate = String.valueOf(col[headers.get("credit card expiration date")]);
                    String nameOnCard = String.valueOf(col[headers.get("name on card")]);
                    String emergencyContactName = String.valueOf(col[headers.get("emergency contact name")]);
                    String emergencyContactPhoneNumber = String.valueOf(col[headers.get("emergency contact phone number")]);
                    String emergencyContactRelationship = String.valueOf(col[headers.get("emergency contact relationship")]);
                    String requests = String.valueOf(col[headers.get("requests")]);
                    CreditCard creditCard = new CreditCard(creditCardNumber, cvv, expirationDate, nameOnCard);
                    EmergencyContact emergencyContact = new EmergencyContact(emergencyContactName, emergencyContactPhoneNumber, emergencyContactRelationship);
                    Patient patient = new Patient(username, password, email, number, gender, insurance, birthday, creditCard, emergencyContact);
                    accounts.put(username, patient);
                }
            }
        }
    }

    @Override
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
     * Return true if and only if the optional parameter was given a value and is not null.
     * @param parameter could be new username, new password, new email, new insurance, new phone number.
     * @return whether the value stored in the parameter is present and not null.
     */
    private boolean optionPresent(String parameter) {
        Optional<String> param = Optional.ofNullable(parameter);
        return param.isPresent();
    }

    public Integer editProfile(String username, String newUsername, String newPassword,
                               String newEmail, String newPhoneNumber, String newInsurance) {
        int changes = 0;
        Patient patient = accounts.get(username);
        if (optionPresent(newUsername) && !existsByName(newUsername)) {
            // if there is no change between the usernames, the exists by name method would have caught it.
            // Therefore, no need for changeExists function.
            patient.setUsername(newUsername);
            save();
            changes += 1;
        } if (optionPresent(newPassword) && changeExists(patient.getPassword(), newPassword)) {
            patient.setPassword(newPassword);
            save();
            changes += 1;
        } if (optionPresent(newEmail) && changeExists(patient.getEmail(), newEmail)) {
            patient.setEmail(newEmail);
            save();
            changes += 1;
        } if (optionPresent(newPhoneNumber) && changeExists(patient.getPhoneNumber(), newPhoneNumber)) {
            patient.setPhoneNumber(newPhoneNumber);
            save();
            changes += 1;
        } if (optionPresent(newInsurance) && changeExists(patient.getInsurance(), newInsurance)) {
            patient.setInsurance(newInsurance);
            save();
            changes += 1;
        }
        return changes;
    }
}

