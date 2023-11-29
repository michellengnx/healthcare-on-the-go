package data_access;

import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import use_case.edit_profile.EditPatientDataAccessInterface;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// add implements SignupUserDataAccessInterface, LoginUserDataAccessInterface
public class FilePatientDataAccessObject implements EditPatientDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Patient> accounts = new HashMap<>();

    public FilePatientDataAccessObject(String csvPath) throws IOException, ParseException {
        csvFile = new File(csvPath);
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
        headers.put("requests", 14);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                assert header.equals("username,password,email,phone_number,gender,insurance,birthday,credit_card_number,cvv,card_expiration_date,name_on_card,emergency_contact_name,emergency_phone_number,emergency_contact_relationship,requests");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String email = String.valueOf(col[headers.get("email")]);
                    String number = String.valueOf(col[headers.get("phone_number")]);
                    String gender = String.valueOf(col[headers.get("gender")]);
                    String insurance = String.valueOf(col[headers.get("insurance")]);
                    Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(col[headers.get("birthday")]));
                    String creditCardNumber = String.valueOf(col[headers.get("credit_card_number")]);
                    int cvv = Integer.parseInt(col[headers.get("cvv")]);
                    String expirationDate = String.valueOf(col[headers.get("card_expiration_date")]);
                    String nameOnCard = String.valueOf(col[headers.get("name_on_card")]);
                    String emergencyContactName = String.valueOf(col[headers.get("emergency_contact_name")]);
                    String emergencyContactPhoneNumber = String.valueOf(col[headers.get("emergency_phone_number")]);
                    String emergencyContactRelationship = String.valueOf(col[headers.get("emergency_contact_relationship")]);
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
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        patient.getUsername(), patient.getPassword(), patient.getEmail(), patient.getPhoneNumber(),
                        patient.getGender(), patient.getInsurance(), patient.getBirthday(),
                        patient.getCreditCard(), patient.getEmergencyContact());
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
     * Edit the profile of a patient
     * @param username that the patient wants to be associated with.
     * @param password that the patient wants to be associated with.
     * @param email that the patient wants to be associated with.
     * @param phoneNumber that the patient wants to be associated with.
     * @param insurance that the patient wants to be associated with.
     * @param creditCardNumber that the patient wants to be associated with.
     * @param cvv that the patient wants to be associated with.
     * @param expirationDate that the patient wants to be associated with.
     * @param nameOnCard that the patient wants to be associated with.
     * @param emergencyName that the patient wants to be associated with.
     * @param emergencyNumber that the patient wants to be associated with.
     * @param emergencyRelationship that the patient wants to be associated with.
     * @return 0 if no changes have been found in a field,
     * 1 if a successful change was found,
     * -1 if an unsuccessful chang was found.
     */
    // add password validator
    @Override
    public Integer[] editProfile(String username, String password, String email, String phoneNumber, String insurance,
                                 String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                                 String emergencyName, String emergencyNumber, String emergencyRelationship) {

        // integer list that initialized 7 Integer elements, with each defaulted to 0
        Integer[] changes = new Integer[7];
        Patient patient = accounts.get(username);

        if (changeExists(patient.getUsername(), username)) {
            if (existsByName(username)) {
                changes[0] = -1;
            } else {
                patient.setUsername(username);
                save();
                changes[0] = 1;
            }
        } if (changeExists(patient.getPassword(), password)) {
            // introduce if statement with password validator
            patient.setPassword(password);
            save();
            changes[1] = 1;
        } if (changeExists(patient.getEmail(), email)) {
            patient.setEmail(email);
            save();
            changes[2] = 1;
        } if (changeExists(patient.getPhoneNumber(), phoneNumber)) {
            patient.setPhoneNumber(phoneNumber);
            save();
            changes[3] = 1;
        } if (changeExists(patient.getInsurance(), insurance)) {
            patient.setInsurance(insurance);
            save();
            changes[4] = 1;
        } if (changeExists(patient.getCreditCard().getCreditCardNumber(), creditCardNumber)) {
            patient.setCreditCard(new CreditCard(creditCardNumber, cvv, expirationDate, nameOnCard));
            save();
            changes[5] = 1;
        } if (changeExists(patient.getEmergencyContact().getName(), emergencyName) &&
                    changeExists(patient.getEmergencyContact().getPhoneNumber(), emergencyNumber)) {
            patient.setEmergencyContact(new EmergencyContact(emergencyName, emergencyNumber, emergencyRelationship));
            save();
            changes[6] = 1;
        }
        return changes;
    }
}

