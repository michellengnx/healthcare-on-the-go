package use_case.CreateRequest;

import entities.Doctor;
import entities.Patient;
import entities.ServiceRequest;
import entities.factories.service_request.ServiceRequestFactory;
import entities.matchers.DoctorMatcher;
import entities.Service;
import entities.matchers.DoctorMatcherApiAccessInterface;
import entities.matchers.DoctorMatcherDataAccessInterface;

import java.util.Date;

public class CreateRequestInteractor implements CreateRequestInputBoundary {
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
        // input data
        Service requestedService = createRequestInputData.getService();
        String destination = createRequestInputData.getDestination();
        Date creationTime = createRequestInputData.getCreationTime();
        int urgencyLevel = createRequestInputData.getUrgencyLevel();
        Patient patient = createRequestInputData.getPatient();

        // create doctor matcher and variable to store matched doctor
        DoctorMatcher matcher = new DoctorMatcher(
                requestedService,
                destination,
                (DoctorMatcherDataAccessInterface) this.doctorDataAccessObject,
                (DoctorMatcherApiAccessInterface) this.apiAccessObject);
        Doctor matchedDoctor;

        try {
            // attempt to match with a doctor and calculate the necessary values needed to create a request
            matchedDoctor = matcher.match();
            float price = this.apiAccessObject.getPrice(matchedDoctor.getLocation(), destination);
            float eta = this.apiAccessObject.getEta(matchedDoctor.getLocation(), destination);
            float distance = this.apiAccessObject.getDistance(matchedDoctor.getLocation(), destination);

            ServiceRequestFactory serviceRequestFactory = new ServiceRequestFactory();

            ServiceRequest request = serviceRequestFactory.create(
                    creationTime,
                    matchedDoctor,
                    urgencyLevel,
                    destination,
                    requestedService,
                    price,
                    eta,
                    distance
            );

            // save the user's request and mark the doctor as busy
            this.userDataAccessObject.saveRequest(patient, request);
            this.doctorDataAccessObject.markAsBusy(matchedDoctor);

            CreateRequestOutputData response = new CreateRequestOutputData(request, patient);

            this.completeRequestPresenter.prepareSuccessView(response);
        } catch (NoAvailableDoctorException e) {
            this.completeRequestPresenter.prepareFailView("No Doctors Available!");
        }
    }
}
