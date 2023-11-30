package use_case.edit_profile;

public interface EditOutputBoundary {
    void prepareSuccessView(EditOutputData patient);

    void prepareFailView(String error);
}
