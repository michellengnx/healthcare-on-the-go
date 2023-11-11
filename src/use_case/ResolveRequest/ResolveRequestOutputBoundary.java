package use_case.ResolveRequest;

/**
 * Output boundary for the resolve request presenter. THe presenter must implement this to adhere to Clean Architecture,
 * and higher or equal policy level classes (namely the interactor) must refer to this interface, rather than the
 * presenter itself. Lower policy level classes ought to use the output boundary as the variable type when instantiating
 * the presenter.
 */
public interface ResolveRequestOutputBoundary {
    /**
     * Update the ViewRequest view to show that the request has been resolved.
     *
     * @param response Data object containing the resolved request and the patient to which it belongs.
     */
    public void prepareSuccessView(ResolveRequestOutputData response);
    public void prepareFailView(String errorMsg);
}
