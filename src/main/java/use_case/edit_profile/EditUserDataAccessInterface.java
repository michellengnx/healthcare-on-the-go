package use_case.edit_profile;

import entities.Patient;
import entities.User;
// should this be renamed to EditPatientDataAccessInterface?
public interface EditUserDataAccessInterface {
    void save(Patient patient);

    Patient get(String username);

    Integer editProfile(String username, String password, String email, String phoneNumber, String insurance);
}
