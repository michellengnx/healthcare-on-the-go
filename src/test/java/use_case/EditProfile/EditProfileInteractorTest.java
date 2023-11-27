package use_case.CreateRequest;

import entities.*;
import use_case.edit_profile.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class EditProfileInteractorTest {
    private EditInputData editInputData;
    private EditPatientDataAccessInterface patientDataAccessInterface;

    @BeforeEach
    void init() {
        editInputData = new EditInputData(
                "kayumova",
                "Izora2004",
                "izora.kayumova@mail.utoronto.ca",
                "437-241-3083",
                "GSC Everywhere");
    }
}
