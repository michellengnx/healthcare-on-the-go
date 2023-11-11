package use_case.ResolveRequest;

/**
 *
 */
public interface ResolveRequestInputBoundary {
    /**
     * Execute the resolve request use case. Mark the patient's request as resolved, and subsequently inform the
     * presenter.
     *
     * @param resolveRequestInputData Input data necessary to resolve a request, namely the patient and the request
     *                                to be resolved.
     */
    public void execute(ResolveRequestInputData resolveRequestInputData);
}
