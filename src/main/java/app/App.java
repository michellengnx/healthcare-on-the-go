package app;


import data_access.ApiAccessObject;
import data_access.DoctorDataAccessObject;
import data_access.FilePatientDataAccessObject;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import interface_adapter.edit_profile.EditViewModel;
import interface_adapter.edited_profile.EditedViewModel;
import view.CreateRequestView;
import view.EditView;
import view.SignUpView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Health Care on the Go");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        // LoginViewModel loginViewModel = new LoginViewModel();
        HomeScreenViewModel homeScreenViewModel = new HomeScreenViewModel();
        SignUpViewModel signupViewModel = new SignUpViewModel();
        // ViewRequestsViewModel viewRequestsViewModel = new ViewRequestsViewModel();
        EditViewModel editProfileViewModel = new EditViewModel();
        EditedViewModel editedViewModel = new EditedViewModel();
        // LeaveReviewViewModel leaveReviewViewModel = new LeaveReviewViewModel();
        CreateRequestViewModel createRequestViewModel = new CreateRequestViewModel();
        ViewRequestViewModel viewRequestViewModel = new ViewRequestViewModel();

        ReturnHomeController returnHomeController = ReturnHomeUseCaseFactory.create(
                viewManagerModel,
                homeScreenViewModel
        );

        FilePatientDataAccessObject userDataAccessObject;
        DoctorDataAccessObject doctorDataAccessObject;
        ApiAccessObject apiAccessObject;
//
        try {
             userDataAccessObject = new FilePatientDataAccessObject("data/patients.csv");
        } catch (IOException | ParseException e) {
             throw new RuntimeException(e);
        }
//
        try {
             doctorDataAccessObject = new DoctorDataAccessObject("data/doctors.csv", "data/services.csv");
        } catch (IOException e) {
             throw new RuntimeException(e);
        }

        apiAccessObject = new ApiAccessObject(System.getenv("API_KEY"));



        // LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        SignUpView signUpView = SignUpUseCaseFactory.create(
                viewManagerModel,
                signupViewModel,
                userDataAccessObject);
        // HomeScreenView homeScreenView = HomeScreenUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        // LeaveReviewView leaveReviewView = LeaveReviewUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        // ViewRequestsView viewRequestsView = ViewRequestsUseCaseFactory.create();
        EditView editProfileView = EditUseCaseFactory.create(
                viewManagerModel,
                editProfileViewModel,
                editedViewModel,
                userDataAccessObject);
        // CreateRequestView createRequestView = CreateRequestUseCaseFactory.create(
        //        viewManagerModel,
        //        createRequestViewModel,
        //        homeScreenViewModel,
        //        apiAccessObject,
        //        userDataAccessObject,
        //        doctorDataAccessObject,
        //        returnHomeController);

        views.add(signUpView, signUpView.viewName);
        // views.add(loginView, loginView.viewName);
        // views.add(homeScreenView, homeScreenView.viewName);
        // views.add(leaveReviewView, leaveReviewView.viewName);
        // views.add(viewRequestsView, viewRequestsView.viewName);
        views.add(editProfileView, editProfileView.viewName);
        // views.add(createRequestView, createRequestView.viewName);

        // viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
