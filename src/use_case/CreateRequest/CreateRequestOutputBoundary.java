package use_case.CreateRequest;

import entities.ServiceRequest;

/**
 * Output boundary for the create request presenter. The presenter must implement this adhere to Clean Architecture,
 * and higher or equal policy level classes (namely the interactor) must refer to this interface, rather than the
 * presenter itself. Lower policy level classes ought to use the output boundary as the variable type when instantiating
 * the presenter.
 */
public interface CreateRequestOutputBoundary {
    /**
     * Switch the current view to the view request screen, and display the details of the current view.
     *
     * @param response Data object containing the created request, and patient for which it was created for.
     */
    public void prepareSuccessView(CreateRequestOutputData response);

    /**
     * Remain in the current view, and display and error message.
     *
     * @param error The error message to be displayed.
     */
    public void prepareFailView(String error);
}
