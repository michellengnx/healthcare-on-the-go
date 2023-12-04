package interface_adapter.HomeScreen;

import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.LockScreen.LockScreenModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import interface_adapter.edit_profile.EditViewModel;
import use_case.HomeScreen.HomeScreenOutputBoundary;
import use_case.HomeScreen.HomeScreenOutputData;

public class HomeScreenPresenter implements HomeScreenOutputBoundary {
    private final CreateRequestViewModel createRequestViewModel;
    private final ViewRequestViewModel viewRequestViewModel;
    private final HomeScreenViewModel homeScreenViewModel;
    private final LockScreenModel lockScreenModel;
    private final ViewManagerModel viewManagerModel;
    private EditViewModel editProfileViewModel;

    /**
     * Create a HomeScreenPresenter given a CreateRequestViewModel and ViewRequestViewModel
     *
     * @param createRequestViewModel The necessary view model to create a request.
     * @param viewRequestViewModel The necessary view model the view a request.
     */
    public HomeScreenPresenter(CreateRequestViewModel createRequestViewModel,
                               ViewRequestViewModel viewRequestViewModel,
                               EditViewModel editProfileViewModel,
                               ViewManagerModel viewManagerModel,
                               LockScreenModel lockScreenModel,
                               HomeScreenViewModel homeScreenViewModel) {
        this.createRequestViewModel = createRequestViewModel;
        this.viewRequestViewModel = viewRequestViewModel;
        this.editProfileViewModel = editProfileViewModel;
        this.viewManagerModel = viewManagerModel;
        this.lockScreenModel = lockScreenModel;
        this.homeScreenViewModel = homeScreenViewModel;
    }

    /**
     * Switch from the home screen view to the view whose name is stored in the output data object.
     *
     * @param outputData Output data object containing the view name to be switched to.
     */
    @Override
    public void prepareSuccessView(HomeScreenOutputData outputData) {
        switch(outputData.getViewName()) {
            case "create request":
                CreateRequestState createRequestState = createRequestViewModel.getState();
                createRequestState.setPatient(homeScreenViewModel.getState().getPatient());
                this.viewManagerModel.setActiveView(createRequestViewModel.getViewName());
                break;
            case "logout":
                this.viewManagerModel.setActiveView(lockScreenModel.getViewName());
                break;
            case "view requests":
                System.out.println("Viewing requests!!!!");
                this.viewManagerModel.setActiveView(viewRequestViewModel.getViewName());
                break;
            case "edit profile":
                this.viewManagerModel.setActiveView(editProfileViewModel.getViewName());
                break;
            case "leave review":
                // this.viewManagerModel.setActiveView(leaveReviewViewModel.getViewName());
                break;
        }
        System.out.println(outputData.getViewName());

        this.viewManagerModel.firePropertyChanged();
    }
}
