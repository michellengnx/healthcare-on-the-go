package interface_adapter.ResolveRequest;

import entities.ServiceRequest;
import org.example.src.entities.Patient;
import use_case.ResolveRequest.ResolveRequestInputBoundary;
import use_case.ResolveRequest.ResolveRequestInputData;

/**
 * A controller response for executing the resolve request use case interaction.
 */
public class ResolveRequestController {
    final private ResolveRequestInputBoundary resolveRequestInputBoundary;

    /**
     * Create the ResolveRequestController given the corresponding interactor.
     *
     * @param resolveRequestInteractor The use case interactor for the resolve request use case.
     */
    public ResolveRequestController(ResolveRequestInputBoundary resolveRequestInteractor) {
        this.resolveRequestInputBoundary = resolveRequestInteractor;
    }

    /**
     * Execute the resolve request use case, passing an input data object created using the arguments to the method.
     *
     * @param request The request to be resolved.
     * @param patient The patient whose request is to be resolved.
     */
    public void execute(ServiceRequest request, Patient patient) {
        ResolveRequestInputData resolveRequestInputData = new ResolveRequestInputData(
                patient,
                request
        );

        resolveRequestInputBoundary.execute(resolveRequestInputData);
    }
}
