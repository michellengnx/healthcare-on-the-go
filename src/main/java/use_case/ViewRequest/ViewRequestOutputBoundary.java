package use_case.ViewRequest;

import use_case.SignUp.SignUpOutputData;

public interface ViewRequestOutputBoundary {
    void prepareSuccessView(ViewRequestOutputData requests);

    void prepareFailView(String error);
}
