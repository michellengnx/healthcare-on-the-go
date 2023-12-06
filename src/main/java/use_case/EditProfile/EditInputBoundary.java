package use_case.EditProfile;

/**
 * Represents the boundary interface for handling input operations related to editing a profile.
 * Implementing classes define the behavior for executing edit operations based on input data.
 */
public interface EditInputBoundary {

    void execute(EditInputData editInputData);
}
