package interface_adapter.CreateRequest;

import entities.Patient;
import entities.Service;
import use_case.CreateRequest.CreateRequestInputBoundary;
import use_case.CreateRequest.CreateRequestInputData;

import java.util.Date;

/**
 * A controller responsible for executing the create request use case interaction.
 */
public class CreateRequestController {
    final CreateRequestInputBoundary createRequestInteractor;

    /**
     * Create the CreateRequestController given the corresponding interactor.
     *
     * @param createRequestInteractor The use case interactor for the create request use case.
     */
    public CreateRequestController(CreateRequestInputBoundary createRequestInteractor) {
        this.createRequestInteractor = createRequestInteractor;
    }

    /**
     * Execute the create request use case, passing an input data object created using the arguments to the method.
     *
     * @param creationTime The time at which the request was created.
     * @param urgencyLevel The request's level of urgency (1 is low, 3 is high).
     * @param destination Where the request is to be carried out.
     * @param service The service requested.
     * @param user The user issuing the request.
     */
    public void execute(Date creationTime, int urgencyLevel, String destination, Service service, Patient user) {
        CreateRequestInputData createRequestInputData = new CreateRequestInputData(
                creationTime,
                urgencyLevel,
                destination,
                service,
                user
        );

        createRequestInteractor.execute(createRequestInputData);
    }
}
