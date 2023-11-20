package interface_adapter.edit_profile;

import interface_adapter.ViewManagerModel;
import interface_adapter.edited_profile.EditedState;
import interface_adapter.edited_profile.EditedViewModel;
import use_case.edit_profile.EditOutputBoundary;
import use_case.edit_profile.EditOutputData;

public class EditPresenter implements EditOutputBoundary {

    private final EditViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;
    private final EditedViewModel editedViewModel;

    public EditPresenter(ViewManagerModel viewManagerModel,
                         EditedViewModel editedViewModel,
                         EditViewModel editViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.editedViewModel = editedViewModel;
        this.editViewModel = editViewModel;
    }

    @Override
    public void prepareSuccessView(EditOutputData response) {

        EditedState editedState = editedViewModel.getState();
        editedState.setUsername(response.getUsername());
        this.editedViewModel.setState(editedState);
        this.editedViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editedViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        EditState editState = editViewModel.getState();
        editState.setUsernameError(error);
        editViewModel.firePropertyChanged();
    }
}
