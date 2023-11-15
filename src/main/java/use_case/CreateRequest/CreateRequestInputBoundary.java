package use_case.CreateRequest;

/**
 * Input boundary for the create request interactor. The interactor must implement this adhere to Clean Architecture
 * Lower policy level classes ought to use the input boundary as the variable type when instantiating the interactor.
 */
public interface CreateRequestInputBoundary {
    /**
     * Perform the use case given some input data, in particular, match the patient with a doctor, create the necessary
     * request, mark the doctor as busy, add the request to the patient's list, and call the presenter. In the case that
     * a doctor cannot be matched, remain on the same screen and call upon the presenter to display an error message.
     *
     * @param createRequestInputData Input data necessary to create a request for medical services.
     */
    public void execute(CreateRequestInputData createRequestInputData);
}
