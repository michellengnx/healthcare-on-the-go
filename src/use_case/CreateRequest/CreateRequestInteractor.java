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

/**
 * The interactor responsible for performing the create request use case. This class combines the logic implemented by
 * the doctor matcher and data access objects and attempts to create a request for a given patient. Exceptional cases
 * such as the unavailability of doctors are handled appropriately.
 */
public class CreateRequestInteractor implements CreateRequestInputBoundary {
    final CreateRequestApiAccessInterface apiAccessObject;
    final CreateRequestDoctorDataAccessInterface doctorDataAccessObject;
    final CreateRequestUserDataAccessInterface userDataAccessObject;
    final CreateRequestOutputBoundary completeRequestPresenter;

    /**
     * Create a CreateRequestInteractor object with given data access objects, and a presenter.
     *
     * @param apiAccessObject Object that can retrieve distance, eta and pricing information.
     * @param doctorDataAccessObject Object that can retrieve and store information about available doctors.
     * @param userDataAccessObject Object that can store information about patients.
     * @param completeRequestPresenter Presenter to be called upon when the use case is complete.
     */
    public CreateRequestInteractor(CreateRequestApiAccessInterface apiAccessObject,
                                   CreateRequestDoctorDataAccessInterface doctorDataAccessObject,
                                   CreateRequestUserDataAccessInterface userDataAccessObject,
                                   CreateRequestOutputBoundary completeRequestPresenter) {
        this.apiAccessObject = apiAccessObject;
        this.doctorDataAccessObject = doctorDataAccessObject;
        this.userDataAccessObject = userDataAccessObject;
        this.completeRequestPresenter = completeRequestPresenter;
    }

    /**
     * Match the patient with a doctor, create the necessary request, mark the doctor as busy, add the request to the
     * patient's list, and call the presenter. Price, eta and distance parameters are determined via the
     * apiAccessObject, doctor matching is performed with the DoctorMatcher, the available doctors are determined via
     * the doctorDataAccess object, and all other data is supplied through the input data argument. In the case that a
     * doctor cannot be matched, remain on the same screen and call upon the presenter to display an error message.
     *
     * @param createRequestInputData Input data necessary to create a request for medical services.
     */
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

            // create the request
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
