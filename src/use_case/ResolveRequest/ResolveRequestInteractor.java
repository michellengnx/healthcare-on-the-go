package use_case.ResolveRequest;

import entities.ServiceRequest;
import org.example.src.entities.Patient;

/**
 * The interactor is responsible for performing the resolve request use case. Simply mark a user's request as completed.
 */
public class ResolveRequestInteractor {
    ResolveRequestUserDataAccessInterface userDataAccessObject;
    ResolveRequestOutputBoundary resolveRequestPresenter;

    /**
     * Create a ResolveRequestInteractor object with a given user data access object, and a presenter.
     *
     * @param userDataAccessObject Object that can edit information about patient requests.
     * @param resolveRequestPresenter Presenter to be called upon when the use case is complete.
     */
    public ResolveRequestInteractor(ResolveRequestUserDataAccessInterface userDataAccessObject,
                                    ResolveRequestOutputBoundary resolveRequestPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.resolveRequestPresenter = resolveRequestPresenter;
    }

    /**
     * Mark the patient's request as completed via the userDataAccessObject. If the request cannot be found, display an
     * error, otherwise, update the view model accordingly.
     *
     * @param resolveRequestInputData Input data object containing the patient and their request to be marked as
     *                                completed.
     */
    public void execute(ResolveRequestInputData resolveRequestInputData) {
        Patient patient = resolveRequestInputData.getPatient();
        ServiceRequest request = resolveRequestInputData.getRequest();

        try {
            this.userDataAccessObject.resolveRequest(patient, request);
            ResolveRequestOutputData response = new ResolveRequestOutputData(patient, request);
            this.resolveRequestPresenter.prepareSuccessView(response);
        } catch (NoRequestFoundException e) {
            this.resolveRequestPresenter.prepareFailView("Couldn't find request");
        }
    }
}
