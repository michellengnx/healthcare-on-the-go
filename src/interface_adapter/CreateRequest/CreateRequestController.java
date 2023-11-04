package interface_adapter.CreateRequest;

import entities.Patient;
import entities.Service;
import use_case.CreateRequest.CreateRequestInputBoundary;
import use_case.CreateRequest.CreateRequestInputData;

import java.util.Date;

public class CreateRequestController {
    final CreateRequestInputBoundary createRequestInteractor;
    public CreateRequestController(CreateRequestInputBoundary createRequestInteractor) {
        this.createRequestInteractor = createRequestInteractor;
    }

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
