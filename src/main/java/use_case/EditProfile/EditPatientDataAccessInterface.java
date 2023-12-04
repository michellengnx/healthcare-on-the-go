package use_case.EditProfile;

import entities.Patient;

/**
 * Interface defining methods to access and modify patient data.
 */
public interface EditPatientDataAccessInterface {

    void save(Patient patient);

    Patient get(String username);

    boolean hasValidPassword(String password);

    Integer[] editProfile(String username, String password, String email, String phoneNumber, String insurance,
                          String creditCardNumber, Integer cvv, String expirationDate, String nameOnCard,
                          String emergencyName, String emergencyNumber, String emergencyRelationship);
}
