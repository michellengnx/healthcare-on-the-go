package app;

import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_profile.EditController;
import interface_adapter.edit_profile.EditPresenter;
import interface_adapter.edit_profile.EditViewModel;
import interface_adapter.edited_profile.EditedViewModel;
import use_case.edit_profile.EditInputBoundary;
import use_case.edit_profile.EditInteractor;
import use_case.edit_profile.EditOutputBoundary;
import use_case.edit_profile.EditPatientDataAccessInterface;
import view.EditView;

import javax.swing.*;
import java.io.IOException;

/**
 * Factory that facilitates the creation of an EditView and EditController for editing user profiles.
 */
public class EditUseCaseFactory {

    /** Prevent instantiation. */

    private EditUseCaseFactory() {}

    /**
     * Creates an EditView instance based on the provided parameters.
     *
     * @param viewManagerModel       Model controlling the current view being shown.
     * @param editViewModel          Model storing data for editing a user's profile.
     * @param editedViewModel       Model storing data for the edited user profile.
     * @param patientDataAccessObject Object providing access to patient data.
     * @return The view for editing user profiles.
     */
    public static EditView create(
            ViewManagerModel viewManagerModel,
            EditViewModel editViewModel,
            EditedViewModel editedViewModel,
            EditPatientDataAccessInterface patientDataAccessObject,
            ReturnHomeController returnHomeController) {

        try {
            EditController editController = createEditUseCase(viewManagerModel, editViewModel, editedViewModel, patientDataAccessObject);
            return new EditView(editViewModel, editController, returnHomeController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Creates an EditController responsible for handling the edit profile use case.
     *
     * @param viewManagerModel Model controlling the current view being shown.
     * @param editViewModel Model storing data for editing a user's profile.
     * @param editedViewModel Model storing data for the edited user profile.
     * @param patientDataAccessObject Object providing access to patient data.
     * @return The controller for executing the edit profile use case.
     * @throws IOException If the patient data access object encounters a file access issue.
     */
    private static EditController createEditUseCase(
            ViewManagerModel viewManagerModel,
            EditViewModel editViewModel,
            EditedViewModel editedViewModel,
            EditPatientDataAccessInterface patientDataAccessObject) throws IOException {

        EditOutputBoundary editOutputBoundary = new EditPresenter(viewManagerModel, editedViewModel, editViewModel);

        EditInputBoundary editInteractor = new EditInteractor(patientDataAccessObject, editOutputBoundary);

        return new EditController(editInteractor);
    }
}
