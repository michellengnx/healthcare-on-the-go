package use_case.edit_profile;

/**
 * Boundary interface for presenting output related to editing a profile.
 */
public interface EditOutputBoundary {

    void prepareSuccessView(EditOutputData patient);

    void prepareFailView(String error);
}
