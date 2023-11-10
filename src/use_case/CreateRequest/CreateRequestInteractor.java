package use_case.CreateRequest;

import entities.Doctor;
import entities.Patient;
import entities.ServiceRequest;
import entities.factories.service_request.ServiceRequestFactory;
import entities.matchers.DoctorMatcher;
import entities.Service;

import java.util.*;

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
        DoctorMatcher matcher;
        try {
            matcher = new DoctorMatcher(
                    requestedService,
                    createDoctorEtaMap(destination));
        } catch (InvalidLocationException e) {
            this.completeRequestPresenter.prepareFailView("Invalid location!");
            return;
        }
        Doctor matchedDoctor;

        float servicePrice;
        float travelPrice;
        float eta;
        float distance;

        try {
            // attempt to match with a doctor and calculate the necessary values needed to create a request
            matchedDoctor = matcher.match();
        } catch (NoAvailableDoctorException e) {
            this.completeRequestPresenter.prepareFailView("No Doctors Available!");
            return;
        }

        servicePrice = requestedService.getPrice();

        try {
            travelPrice = this.apiAccessObject.getPrice(matchedDoctor.getLocation(), destination);
            eta = this.apiAccessObject.getEta(matchedDoctor.getLocation(), destination);
            distance = this.apiAccessObject.getDistance(matchedDoctor.getLocation(), destination);
        } catch (InvalidLocationException e) {
            this.completeRequestPresenter.prepareFailView("Invalid location!");
            return;
        }

        // create the request
        ServiceRequestFactory serviceRequestFactory = new ServiceRequestFactory();

        ServiceRequest request = serviceRequestFactory.create(
                creationTime,
                matchedDoctor,
                urgencyLevel,
                destination,
                requestedService,
                travelPrice + servicePrice,
                eta,
                distance
        );

        // save the user's request and mark the doctor as busy
        this.userDataAccessObject.saveRequest(patient, request);
        this.doctorDataAccessObject.markAsBusy(matchedDoctor);

        CreateRequestOutputData response = new CreateRequestOutputData(request, patient);

        this.completeRequestPresenter.prepareSuccessView(response);

    }

    /**
     * Get a Map from available doctors to their ETA to destination.
     *
     * @param destination The destination to which the doctor is traveling.
     * @return A Map from available doctors to their ETA to destination.
     */
    private Map<Doctor, Float> createDoctorEtaMap(String destination) throws InvalidLocationException {
        List<Doctor> availableDoctors = this.doctorDataAccessObject.getAvailableDoctors();
        Map<Doctor, Float> doctorEtaMap = new HashMap<>();

        for (Doctor doctor : availableDoctors) {
            doctorEtaMap.put(doctor, this.apiAccessObject.getEta(doctor.getLocation(), destination));
        }

        return doctorEtaMap;
    }
}
