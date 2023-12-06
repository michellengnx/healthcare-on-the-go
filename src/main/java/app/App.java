package app;




import data_access.*;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.HomeScreen.HomeScreenViewModel;
import interface_adapter.Login.LoginViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;
import interface_adapter.ReturnToLock.ReturnToLockController;
import interface_adapter.SignUp.SignUpViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import interface_adapter.edit_profile.EditViewModel;
import interface_adapter.edited_profile.EditedViewModel;
import interface_adapter.LockView.LockViewModel;
import view.*;


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
    public static void main( String[] args ) {
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
        LoginViewModel loginViewModel = new LoginViewModel();
        HomeScreenViewModel homeScreenViewModel = new HomeScreenViewModel();
        SignUpViewModel signupViewModel = new SignUpViewModel();
        EditViewModel editProfileViewModel = new EditViewModel();
        EditedViewModel editedViewModel = new EditedViewModel();
        // LeaveReviewViewModel leaveReviewViewModel = new LeaveReviewViewModel();
        CreateRequestViewModel createRequestViewModel = new CreateRequestViewModel();
        ViewRequestViewModel viewRequestViewModel = new ViewRequestViewModel();
        LockViewModel lockViewModel = new LockViewModel();


        ReturnHomeController returnHomeController = ReturnHomeUseCaseFactory.create(
                viewManagerModel,
                homeScreenViewModel
        );
        ReturnToLockController returnToLockController = ReturnToLockUseCaseFactory.create(
                viewManagerModel,
                lockViewModel
        );

        FilePatientDataAccessObject userDataAccessObject;
        DoctorDataAccessObject doctorDataAccessObject;
        ApiAccessObject apiAccessObject;
        FileRequestDataAccessObject requestDataAccessObject;
        FileUserRequestDataAccessObject userRequestDataAccessObject;
//
        try {
            userDataAccessObject = new FilePatientDataAccessObject("data/patients.csv");
            requestDataAccessObject = new FileRequestDataAccessObject("data/requests.csv");
            userRequestDataAccessObject = new FileUserRequestDataAccessObject(userDataAccessObject, requestDataAccessObject);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
//
        doctorDataAccessObject = new DoctorDataAccessObject("data/doctors.csv", "data/services.csv");


        apiAccessObject = new ApiAccessObject(System.getenv("API_KEY"));


        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, homeScreenViewModel, userDataAccessObject, returnToLockController);
        SignUpView signUpView = SignUpUseCaseFactory.create(
                viewManagerModel,
                signupViewModel,
                loginViewModel,
                userDataAccessObject,
                returnToLockController);
        ViewRequestsView viewRequestsView = ViewRequestUseCaseFactory.create(viewManagerModel, viewRequestViewModel, requestDataAccessObject, returnHomeController);
        HomeScreenView homeScreenView = HomeScreenUseCaseFactory.create(viewManagerModel, createRequestViewModel, viewRequestViewModel, editProfileViewModel, lockViewModel, homeScreenViewModel, viewRequestsView.getRequestController());
        // LeaveReviewView leaveReviewView = LeaveReviewUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        EditView editProfileView = EditUseCaseFactory.create(
               viewManagerModel,
               editProfileViewModel,
               editedViewModel,
               userDataAccessObject,
                returnHomeController);
        EditedView editedProfileView = EditedUseCaseFactory.create(
                editedViewModel,
                returnHomeController
        );
        CreateRequestView createRequestView = CreateRequestUseCaseFactory.create(
               viewManagerModel,
               createRequestViewModel,
               homeScreenViewModel,
               apiAccessObject,
               userRequestDataAccessObject,
               doctorDataAccessObject,
               returnHomeController,
                doctorDataAccessObject.getAvailableServices());
        LockView lockView = LockUseCaseFactory.create(
                viewManagerModel,
                lockViewModel,
                signupViewModel,
                loginViewModel
        );


        views.add(signUpView, signUpView.viewName);
        views.add(loginView, loginView.viewName);
        views.add(homeScreenView, homeScreenView.viewName);
        views.add(editedProfileView, editedProfileView.viewName);
        // views.add(leaveReviewView, leaveReviewView.viewName);
        views.add(viewRequestsView, viewRequestsView.viewName);
        views.add(editProfileView, editProfileView.viewName);
        views.add(createRequestView, createRequestView.viewName);
        views.add(lockView, lockView.viewName);

        viewManagerModel.setActiveView(lockView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}


