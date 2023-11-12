package org.example.src.data_access;

import org.example.src.entities.User;
import org.example.src.entities.UserFactory;
import org.example.src.use_case.edit_profile.EditUserDataAccessInterface;
import org.example.src.use_case.login.LoginUserDataAccessInterface;
import org.example.src.use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, EditUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("gender", 2);
        headers.put("insurance", 3);
        headers.put("birthday", 4);
        headers.put("email", 5);
        headers.put("number", 6);
        headers.put("requests", 7);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                assert header.equals("username,password,gender,insurance,birthday,email,number,requests");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String gender = String.valueOf(col[headers.get("gender")]);
                    String insurance = String.valueOf(col[headers.get("insurance")]);
                    String birthday = String.valueOf(col[headers.get("birthday")]);
                    String email = String.valueOf(col[headers.get("email")]);
                    String number = String.valueOf(col[headers.get("number")]);
                    String requests = String.valueOf(col[headers.get("requests")]);
                    User user = userFactory.create(username, password, gender, insurance, birthday, email, number);
                    accounts.put(username, user);
                }
            }
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s",
                        user.getUsername(), user.getPassword(), user.getGender(),
                        user.getInsurance(), user.getBirthday(), user.getEmail(), user.getPhoneNumber());
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
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    /**
     * Edit the account of a user based on the user's requested changes.
     * @param username the username of the user who requested the change.
     * @param newUsername the new username the user wants their account to be associated with.
     * @param newPassword the new password the user wants their account to be associated with.
     * @param newInsurance the new insurance the user wants their account to be associated with.
     * @param newEmail the new email the user wants their account to be associated with.
     * @param newPhoneNumber the new phone number the user wants their account to be associated with.
     * @return the parameters that have successfully edited as requested by the user.
     */

    // find out if this is okay or better to have separate edit profile methods
    @Override
    public String editProfile(String username, String newUsername, String newPassword, String newInsurance, String newEmail,
                              String newPhoneNumber) {
        User user = accounts.get(username);
        String changes = "";

        if (!username.equals(newUsername)) {
            changes += "username ";
            user.setUsername(newUsername);
        } if (!user.getPassword().equals(newPassword)) {
            changes += " password";
            user.setPassword(newPassword);
        } if (!user.getInsurance().equals(newInsurance)) {
            changes += " insurance,";
            user.setInsurance(newInsurance);
        } if (!user.getEmail().equals(newEmail)) {
            changes += " email,";
            user.setEmail(newEmail);
        } if (!user.getPhoneNumber().equals(newPhoneNumber)) {
            changes += " phone number";
            user.setPhoneNumber(newPhoneNumber);
        }
        save();
        return changes;
    }

}
