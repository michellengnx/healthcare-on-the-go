package use_case.EditProfile;

/**
 * Boundary interface for presenting output related to editing a profile.
 */
public interface EditOutputBoundary {

    void prepareSuccessView(EditOutputData patient);

    void prepareFailView(String error);
}
