package interface_adapter.edit_profile;

import interface_adapter.ViewManagerModel;
import use_case.edit_profile.EditOutputBoundary;

public class EditPresenter implements EditOutputBoundary {

    private final EditViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;
    private final EditedViewModel editedViewModel;
}
