package use_case.edit_profile;

import entities.Patient;

import java.util.List;

public interface EditPatientDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Patient patient);

    Patient get(String username);

    boolean hasValidPassword(String password);

    Integer[] editProfile(String oldUsername, String username, String password, String email, String phoneNumber, String insurance,
                          String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                          String emergencyName, String emergencyNumber, String emergencyRelationship);
}
