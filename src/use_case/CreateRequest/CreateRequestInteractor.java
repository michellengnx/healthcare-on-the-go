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
        Service requestedService = createRequestInputData.getService();
        String destination = createRequestInputData.getDestination();
        Date creationTime = createRequestInputData.getCreationTime();
        int urgencyLevel = createRequestInputData.getUrgencyLevel();
        Patient patient = createRequestInputData.getPatient();

        DoctorMatcher matcher = new DoctorMatcher(
                requestedService,
                destination,
                (DoctorMatcherDataAccessInterface) this.doctorDataAccessObject,
                (DoctorMatcherApiAccessInterface) this.apiAccessObject);
        Doctor matchedDoctor;

        try {
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

            this.userDataAccessObject.saveRequest(patient, request);
            this.completeRequestPresenter.prepareSuccessView(request);
        } catch (NoAvailableDoctorException e) {
            this.completeRequestPresenter.prepareFailView("No Doctors Available!");
        }
    }
}
