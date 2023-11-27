package use_case.edit_profile;

import entities.Patient;

public interface EditPatientDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Patient patient);

    Patient get(String username);

    Integer editProfile(String username, String password, String email, String phoneNumber, String insurance);
}