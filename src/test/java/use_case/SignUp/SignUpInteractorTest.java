package use_case.SignUp;

import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import entities.factories.user.PatientUserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignUpInteractorTest {

    @Mock
    private SignUpUserDataAccessInterface userDataAccessObject;

    @Mock
    private SignUpOutputBoundary userPresenter;

    @Mock
    private PatientUserFactory patientUserFactory;

    @InjectMocks
    private SignUpInteractor signUpInteractor;

    @Test
    void testSignUpSuccess() {
        // Arrange
        SignUpInputData inputData = createTestInputData();

        // Create a real CreditCard object for the Patient
        CreditCard creditCard = new CreditCard(
                inputData.getCreditCardNumber(),
                inputData.getCcv(),
                inputData.getExpirationDate(),
                inputData.getNameOnCard()
        );

        // Create a real EmergencyContact object for the Patient
        EmergencyContact emergencyContact = new EmergencyContact(
                inputData.getContactName(),
                inputData.getContactPhoneNumber(),
                inputData.getContactRelationship()
        );

        // Create a real Patient object
        Patient createdPatient = new Patient(
                inputData.getUsername(),
                inputData.getPassword(),
                inputData.getEmail(),
                inputData.getPhoneNumber(),
                inputData.getGender(),
                inputData.getInsurance(),
                inputData.getBirthday(),
                creditCard,
                emergencyContact
        );

        when(userDataAccessObject.existsByUsername(inputData.getUsername())).thenReturn(false);
        when(userDataAccessObject.existsByEmail(inputData.getEmail())).thenReturn(false);
        when(patientUserFactory.create(
                anyString(),
                anyString(),
                anyString(),
                anyString(),
                anyString(),
                anyString(),
                any(Date.class),
                anyString(),
                anyInt(),
                anyString(),
                anyString(),
                anyString(),
                anyString(),
                anyString()))
                .thenReturn(createdPatient);

        // Act
        signUpInteractor.execute(inputData);

        // Assert
        verify(userDataAccessObject).save(createdPatient);
        verify(userPresenter).prepareSuccessView(any(SignUpOutputData.class));

    }

    @Test
    void testSignUpUsernameExists() {
        // Arrange
        SignUpInputData inputData = createTestInputData();

        when(userDataAccessObject.existsByUsername(inputData.getUsername())).thenReturn(true);

        // Act
        signUpInteractor.execute(inputData);

        // Assert
        verify(userPresenter).prepareFailView("Username already exists.");
        verify(userDataAccessObject, never()).existsByEmail(any());
        verify(userDataAccessObject, never()).save(any());
        verify(userPresenter, never()).prepareSuccessView(any());
    }

    @Test
    void testSignUpEmailExists() {
        // Arrange
        SignUpInputData inputData = createTestInputData();

        when(userDataAccessObject.existsByUsername(inputData.getUsername())).thenReturn(false);
        when(userDataAccessObject.existsByEmail(inputData.getEmail())).thenReturn(true);

        // Act
        signUpInteractor.execute(inputData);

        // Assert
        verify(userPresenter).prepareFailView("Email already exists.");
        verify(userDataAccessObject, never()).save(any());
        verify(userPresenter, never()).prepareSuccessView(any());
    }


    private SignUpInputData createTestInputData() {
        // Create and return a sample SignUpInputData for testing
        return new SignUpInputData(
                "testUser",
                "testPassword1@",
                "testPassword1@",
                "test@example.com",
                "1234567890",
                "Male",
                "Insurance123",
                new Date(),
                "1234567890123456",
                123,
                "12/25",
                "John Doe",
                "Jane Doe",
                "9876543210",
                "Friend"
        );
    }
}
