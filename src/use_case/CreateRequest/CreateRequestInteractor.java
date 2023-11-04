package use_case.CreateRequest;

import entities.Doctor;

import java.util.List;

public class CreateRequestInteractor {
    final CreateRequestApiAccessInterface apiAccessObject;
    final CreateRequestDoctorDataAccessInterface doctorDataAccessObject;
    final CreateRequestUserDataAccessInterface userDataAccessObject;
    final CreateRequestOutputBoundary completeRequestPresenter;

    public CreateRequestInteractor(CreateRequestApiAccessInterface apiAccessObject,
                                   CreateRequestDoctorDataAccessInterface doctorDataAccessObject,
                                   CreateRequestUserDataAccessInterface userDataAccessObject,
                                   CreateRequestOutputBoundary completeRequestPresenter) {
        this.apiAccessObject = apiAccessObject;
        this.doctorDataAccessObject = doctorDataAccessObject;
        this.userDataAccessObject = userDataAccessObject;
        this.completeRequestPresenter = completeRequestPresenter;
    }

    public void execute(CreateRequestInputData createRequestInputData) {

    }
}
