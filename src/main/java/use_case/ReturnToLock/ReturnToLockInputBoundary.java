package use_case.ReturnToLock;

/**
 * Input boundary for the return home interactor. The interactor must implement this adhere to Clean Architecture
 * Lower policy level classes ought to use the input boundary as the variable type when instantiating the interactor.
 */
public interface ReturnToLockInputBoundary {

    /**
     * Execute the return home use case, i.e. set the current view to the home screen.
     */
    public void execute();
}
