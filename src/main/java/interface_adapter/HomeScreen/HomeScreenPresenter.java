package interface_adapter.HomeScreen;

import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.HomeScreen.HomeScreenOutputBoundary;
import use_case.HomeScreen.HomeScreenOutputData;
import view.CreateRequestView;

public class HomeScreenPresenter implements HomeScreenOutputBoundary {
    private CreateRequestViewModel createRequestViewModel;
    private ViewRequestViewModel viewRequestViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Create a HomeScreenPresenter given a CreateRequestViewModel and ViewRequestViewModel
     *
     * @param createRequestViewModel The necessary view model to create a request.
     * @param viewRequestViewModel The necessary view model the view a request.
     */
    public HomeScreenPresenter(CreateRequestViewModel createRequestViewModel,
                               ViewRequestViewModel viewRequestViewModel,
                               ViewManagerModel viewManagerModel) {
        this.createRequestViewModel = createRequestViewModel;
        this.viewRequestViewModel = viewRequestViewModel;
        this.viewManagerModel = viewManagerModel;
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
                this.viewManagerModel.setActiveView(createRequestViewModel.getViewName());
                break;
            case "logout":
                // this.viewManagerModel.setActiveView(signupViewModel.getViewName());
                break;
            case "view requests":
                this.viewManagerModel.setActiveView(viewRequestViewModel.getViewName());
                break;
            case "leave review":
                // this.viewManagerModel.setActiveView(leaveReviewViewModel.getViewName());
                break;
        }

        this.viewManagerModel.firePropertyChanged();
    }
}