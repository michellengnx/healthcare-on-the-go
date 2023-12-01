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
        editedState.setPassword(response.getPassword());
        editedState.setEmail(response.getEmail());
        editedState.setPhoneNumber(response.getPhoneNumber());
        editedState.setInsurance(response.getInsurance());
        editedState.setCreditCardNumber(response.getCreditCardNumber());
        editedState.setCvv(response.getCvv());
        editedState.setExpirationDate(response.getExpirationDate());
        editedState.setNameOnCard(response.getNameOnCard());
        editedState.setEmergencyName(response.getEmergencyName());
        editedState.setEmergencyNumber(response.getEmergencyNumber());
        editedState.setEmergencyRelationship(response.getEmergencyRelationship());
        this.editedViewModel.setState(editedState);
        this.editedViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editedViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        EditState editState = editViewModel.getState();
        editState.setPasswordError(error);
        editViewModel.firePropertyChanged();
    }
}
