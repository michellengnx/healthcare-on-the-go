package app;

import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.EditedProfile.EditedViewModel;
import view.EditedView;

/**
 * Factory that facilitates the creation of an EditView and EditController for editing user profiles.
 */
public class EditedUseCaseFactory {

    /**
     * Prevent instantiation.
     */

    private EditedUseCaseFactory() {
    }

    /**
     * Creates an EditedView instance based on the provided parameters.
     *
     * @param editedViewModel      Model storing data for the edited user profile.
     * @param returnHomeController Controller to return home
     * @return The view for edited user profiles.
     */
    public static EditedView create(
            EditedViewModel editedViewModel,
            ReturnHomeController returnHomeController) {

        return new EditedView(editedViewModel, returnHomeController);
    }
}