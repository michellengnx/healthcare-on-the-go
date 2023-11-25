package app;


import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import view.CreateRequestView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
        // HomeScreenViewModel homeScreenViewModel = new HomeScreenViewModel();
        // SignupViewModel signupViewModel = new SignupViewModel();
        // ViewRequestsViewModel viewRequestsViewModel = new ViewRequestsViewModel();
        // EditProfileViewModel editProfileViewModel = new EditProfileViewModel();
        // LeaveReviewViewModel leaveReviewViewModel = new LeaveReviewViewModel();
        CreateRequestViewModel createRequestViewModel = new CreateRequestViewModel(null);
        ViewRequestViewModel viewRequestViewModel = new ViewRequestViewModel();
        HomeScreenViewModel homeScreenViewModel = new HomeScreenViewModel();


        ReturnHomeController returnHomeController = ReturnHomeUseCaseFactory.create(
                viewManagerModel,
                homeScreenViewModel
        );

        // FileUserDataAccessObject userDataAccessObject;
        // FileDoctorDataAccessObject doctorDataAccessObject;
        // MapApiAccessObject apiAccessObject;
//
        // try {
        //     userDataAccessObject = new FileUserDataAccessObject();
        // } catch (IOException e) {
        //     throw new RuntimeException(e);
        // }
//
        // try {
        //     doctorDataAccessObject = new FileDoctorDataAccessObject();
        // } catch (IOException e) {
        //     throw new RuntimeException(e);
        // }
//
        // try {
        //     apiAccessObject = new MapquestApiAccessObject();
        // } catch (IOException e) {
        //     throw new RuntimeException(e);
        // }


        // LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        // SignUpView signUpView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        // HomeScreenView homeScreenView = HomeScreenUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        // LeaveReviewView leaveReviewView = LeaveReviewUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        // ViewRequestsView viewRequestsView = ViewRequestsUseCaseFactory.create();
        // EditProfile editProfileView = EditProfileUseCaseFactory.create();
        // CreateRequestView createRequestView = CreateRequestUseCaseFactory.create(
        //         viewManagerModel,
        //         createRequestViewModel,
        //         viewRequestViewModel,
        //         apiAccessObject,
        //         userDataAccessObject,
        //         doctorDataAccessObject,
        //         returnHomeController);

        // views.add(signupView, signupView.viewName);
        // views.add(loginView, loginView.viewName);
        // views.add(homeScreenView, homeScreenView.viewName);
        // views.add(leaveReviewView, leaveReviewView.viewName);
        // views.add(viewRequestsView, viewRequestsView.viewName);
        // views.add(editProfileView, editProfileView.viewName);
        // views.add(createRequestView, createRequestView.viewName);

        // viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
