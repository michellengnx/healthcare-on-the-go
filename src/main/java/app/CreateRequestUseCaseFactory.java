package app;

import entities.Service;
import interface_adapter.CreateRequest.CreateRequestController;
import interface_adapter.CreateRequest.CreateRequestPresenter;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.CreateRequest.*;
import view.CreateRequestView;

import javax.swing.*;
import java.io.IOException;
import java.util.Map;

/**
 * Factory that can be used to create the CreateRequestView and CreateRequestController.
 */
public class CreateRequestUseCaseFactory {
    /**
     * Create a CreateRequestView given the necessary models and data access objects.
     *
     * @param viewManagerModel Model that controller the current view being shown.
     * @param createRequestViewModel Model that stores the data for the create request use case.
     * @param apiAccessObject Object that provides access to the uber and map quest api.
     * @param userDataAccessObject Object that provides access to user data.
     * @param doctorDataAccessObject Object that provides access to doctor data.
     * @param returnHomeController Controller that can execute the return home use case.
     * @return The view that provides users an interface to create a request.
     */
    public static CreateRequestView create(ViewManagerModel viewManagerModel,
                                           CreateRequestViewModel createRequestViewModel,
                                           HomeScreenViewModel homeScreenViewModel,
                                           CreateRequestApiAccessInterface apiAccessObject,
                                           CreateRequestUserDataAccessInterface userDataAccessObject,
                                           CreateRequestDoctorDataAccessInterface doctorDataAccessObject,
                                           ReturnHomeController returnHomeController,
                                           Map<String, Service> availableServices) {

        try {
            CreateRequestController createRequestController = createCreateRequestUseCase(
                    viewManagerModel,
                    createRequestViewModel,
                    homeScreenViewModel,
                    apiAccessObject,
                    userDataAccessObject,
                    doctorDataAccessObject);
            return new CreateRequestView(createRequestController, returnHomeController, createRequestViewModel, availableServices);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        }

        return null;
    }

    /**
     * Create a CreateRequestController given the necessary models and data access objects.
     *
     * @param viewManagerModel Model that controller the current view being shown.
     * @param createRequestViewModel Model that stores the data for the create request use case.
     * @param apiAccessObject Object that provides access to the uber and map quest api.
     * @param userDataAccessObject Object that provides access to user data.
     * @param doctorDataAccessObject Object that provides access to doctor data.
     * @return The controller responsible for executing the create request use case.
     * @throws IOException If one of the access objects is unable to open a file / access the api.
     */
    private static CreateRequestController createCreateRequestUseCase(ViewManagerModel viewManagerModel,
                                                                      CreateRequestViewModel createRequestViewModel,
                                                                      HomeScreenViewModel homeScreenViewModel,
                                                                      CreateRequestApiAccessInterface apiAccessObject,
                                                                      CreateRequestUserDataAccessInterface userDataAccessObject,
                                                                      CreateRequestDoctorDataAccessInterface doctorDataAccessObject) throws IOException {

        CreateRequestOutputBoundary createRequestOutputBoundary = new CreateRequestPresenter(
                viewManagerModel,
                createRequestViewModel,
                homeScreenViewModel);

        CreateRequestInputBoundary createRequestInteractor = new CreateRequestInteractor(
                apiAccessObject,
                doctorDataAccessObject,
                userDataAccessObject,
                createRequestOutputBoundary);

        return new CreateRequestController(createRequestInteractor);
    }
}