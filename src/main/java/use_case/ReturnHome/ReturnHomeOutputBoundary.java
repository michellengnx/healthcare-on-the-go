package use_case.ReturnHome;

/**
 * Output boundary for the create request presenter. The presenter must implement this adhere to Clean Architecture, and
 * higher and equal policy level classes (namely the interactor) must refer to the output boundary rather than the
 * presenter itself. Lower policy level classes ought to use the input boundary as the variable type when instantiating
 * the interactor.
 */
public interface ReturnHomeOutputBoundary {
    /**
     * Change the current view to the home screen.
     */
    public void prepareSuccessView();
}
