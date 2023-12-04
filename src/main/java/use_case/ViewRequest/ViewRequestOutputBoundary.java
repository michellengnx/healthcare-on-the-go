package use_case.ViewRequest;

import use_case.SignUp.SignUpOutputData;


/**
 * Interface defining the output boundaries for viewing request details.
 */
public interface ViewRequestOutputBoundary {
    void prepareSuccessView(ViewRequestOutputData requests);

    void prepareFailView(String error);
}
