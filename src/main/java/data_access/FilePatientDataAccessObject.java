package data_access;

import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import use_case.Login.LoginUserDataAccessInterface;
import use_case.SignUp.SignUpUserDataAccessInterface;
import use_case.edit_profile.EditPatientDataAccessInterface;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Manages data access for patient profiles using a CSV file as the data store.
 */
// add implements LoginUserDataAccessInterface
public class FilePatientDataAccessObject implements EditPatientDataAccessInterface, SignUpUserDataAccessInterface, LoginUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Patient> accounts = new HashMap<>();

    public FilePatientDataAccessObject(String csvPath) throws IOException, ParseException {
        csvFile = new File("data/patient.csv");
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("email", 2);
        headers.put("phone_number", 3);
        headers.put("gender", 4);
        headers.put("insurance", 5);
        headers.put("birthday", 6);
        headers.put("credit_card_number", 7);
        headers.put("cvv", 8);
        headers.put("card_expiration_date", 9);
        headers.put("name_on_card", 10);
        headers.put("emergency_contact_name", 11);
        headers.put("emergency_phone_number", 12);
        headers.put("emergency_contact_relationship", 13);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                assert header.equals("username,password,email,phone_number,gender,insurance,birthday,credit_card_number,cvv,card_expiration_date,name_on_card,emergency_contact_name,emergency_phone_number,emergency_contact_relationship");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String email = String.valueOf(col[headers.get("email")]);
                    String number = String.valueOf(col[headers.get("phone_number")]);
                    String gender = String.valueOf(col[headers.get("gender")]);
                    String insurance = String.valueOf(col[headers.get("insurance")]);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                    Date birthday = dateFormat.parse(String.valueOf(col[headers.get("birthday")]));
                    String creditCardNumber = String.valueOf(col[headers.get("credit_card_number")]);
                    int cvv = Integer.parseInt(col[headers.get("cvv")]);
                    String expirationDate = String.valueOf(col[headers.get("card_expiration_date")]);
                    String nameOnCard = String.valueOf(col[headers.get("name_on_card")]);
                    String emergencyContactName = String.valueOf(col[headers.get("emergency_contact_name")]);
                    String emergencyContactPhoneNumber = String.valueOf(col[headers.get("emergency_phone_number")]);
                    String emergencyContactRelationship = String.valueOf(col[headers.get("emergency_contact_relationship")]);
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
    public boolean existByUsername(String identifier) {
        return accounts.containsKey(identifier);
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
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        patient.getUsername(), patient.getPassword(), patient.getEmail(), patient.getPhoneNumber(),
                        patient.getGender(), patient.getInsurance(), patient.getBirthday(),
                        patient.getCreditCard().getCreditCardNumber(), patient.getCreditCard().getCcv(), patient.getCreditCard().getExpirationDate(), patient.getCreditCard().getNameOnCard(),
                        patient.getEmergencyContact().getName(), patient.getEmergencyContact().getPhoneNumber(), patient.getEmergencyContact().getRelationship());
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

    /**
     * Checks whether the provided password meets the required criteria.
     *
     * @param password The password to validate.
     * @return True if the password meets the specified criteria, otherwise false.
     */
    @Override
    public boolean hasValidPassword(String password) {
        // Regex to check valid password.
//        At least 8 chars
//
//        Contains at least one digit
//
//        Contains at least one lower alpha char and one upper alpha char
//
//        Contains at least one char within a set of special chars (@#%$^ etc.)
//
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";


        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }
    private boolean changeExists(String old, String updated) {
        return !old.equals(updated);
    }

    /**
     * Edits the profile of a patient.
     *
     * @param username the username associated with the user's profile (not editable).
     * @param password the new password for the patient.
     * @param email the new email for the patient.
     * @param phoneNumber the new phone number for the patient.
     * @param insurance the new insurance information for the patient.
     * @param creditCardNumber the new credit card number for the patient.
     * @param cvv the new CVV for the patient's credit card.
     * @param expirationDate the new expiration date for the patient's credit card.
     * @param nameOnCard the new name on the credit card for the patient.
     * @param emergencyName the new emergency contact name for the patient.
     * @param emergencyNumber the new emergency contact number for the patient.
     * @param emergencyRelationship the new relationship with the emergency contact for the patient.
     * @return An array representing changes made:
     *         - 0 if no changes have been found in a field,
     *         - 1 if a successful change was found,
     *         - -1 if an unsuccessful change was found.
     */
    // add password validator
    @Override
    public Integer[] editProfile(String username, String password, String email, String phoneNumber, String insurance,
                                 String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                                 String emergencyName, String emergencyNumber, String emergencyRelationship) {

        // integer list that initialized 7 Integer elements for each parameter that is editable
        Integer[] changes = new Integer[6];
        Arrays.fill(changes, 0);

        Patient patient = accounts.get(username);

        if (changeExists(patient.getPassword(), password)) {
            if (!hasValidPassword(password) || password.isEmpty()) {
                changes[0] = -1;
            } else {
                patient.setPassword(password);
                changes[0] = 1;
            }
        } if (changeExists(patient.getEmail(), email) && !email.isEmpty()) {
            patient.setEmail(email);
            changes[1] = 1;
        } if (changeExists(patient.getPhoneNumber(), phoneNumber) && !phoneNumber.isEmpty()) {
            patient.setPhoneNumber(phoneNumber);
            changes[2] = 1;
        } if (changeExists(patient.getInsurance(), insurance) && !insurance.isEmpty()) {
            patient.setInsurance(insurance);
            changes[3] = 1;
        } if (changeExists(patient.getCreditCard().getCreditCardNumber(), creditCardNumber) && !creditCardNumber.isEmpty()) {
            patient.setCreditCard(new CreditCard(creditCardNumber, cvv, expirationDate, nameOnCard));
            changes[4] = 1;
        } if ((changeExists(patient.getEmergencyContact().getName(), emergencyName) ||
                    changeExists(patient.getEmergencyContact().getPhoneNumber(), emergencyNumber) ||
                changeExists(patient.getEmergencyContact().getRelationship(), emergencyRelationship)) &&
                !emergencyName.isEmpty() && !emergencyNumber.isEmpty() && !emergencyRelationship.isEmpty()) {
            patient.setEmergencyContact(new EmergencyContact(emergencyName, emergencyNumber, emergencyRelationship));
            changes[5] = 1;
        }

        save();
        return changes;
    }

    /**
     * Checks whether a user exists with a specific username.
     *
     * @param username The username to check.
     * @return True if a user exists with the provided username, otherwise false.
     */
    @Override
    public boolean existsByUsername(String username) {
        System.out.println(accounts.keySet());
        return accounts.containsKey(username);
    }

    /**
     * Checks whether a user exists with a specific email.
     *
     * @param email The email to check.
     * @return True if a user exists with the provided email, otherwise false.
     */
//    TODO: implement
    @Override
    public boolean existsByEmail(String email) {
        return false;
    }


}

