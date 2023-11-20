package use_case.edit_profile;

import entities.Patient;

// should this be renamed to EditPatientDataAccessInterface?
public interface EditPatientDataAccessInterface {
    void save(Patient patient);

    Patient get(String username);

    Integer editProfile(String username, String password, String email, String phoneNumber, String insurance);
}
