package org.example.src.use_case.edit_profile;

public interface EditOutputBoundary {
    void prepareSuccessView(EditOutputData user);

    void prepareFailView(String error);
}
