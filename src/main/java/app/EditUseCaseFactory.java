package app;

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

public class EditUseCaseFactory {

    /** Prevent instantiation. */

    private EditUseCaseFactory() {}

    public static EditView create(
            ViewManagerModel viewManagerModel,
            EditViewModel editViewModel,
            EditedViewModel editedViewModel,
            EditPatientDataAccessInterface patientDataAccessObject) {

        try {
            EditController editController = createEditUseCase(viewManagerModel, editViewModel, editedViewModel, patientDataAccessObject);
            return new EditView(editViewModel, editController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

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
