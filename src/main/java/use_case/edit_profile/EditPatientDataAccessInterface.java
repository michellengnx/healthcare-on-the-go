package use_case.edit_profile;

import entities.Patient;

import java.util.List;

public interface EditPatientDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Patient patient);

    Patient get(String username);

    List<Integer> editProfile(String username, String password, String email, String phoneNumber, String insurance,
                              String emergencyName, String emergencyNumber, String emergencyRelationship,
                              String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard);
}
