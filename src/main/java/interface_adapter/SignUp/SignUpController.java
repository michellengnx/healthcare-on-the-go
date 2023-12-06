package interface_adapter.SignUp;

import use_case.SignUp.SignUpInputBoundary;
import use_case.SignUp.SignUpInputData;

import java.util.Date;

/**
 * Controller handling sign-up functionalities in the application.
 */
public class SignUpController {
    final SignUpInputBoundary userSignUpUseCaseInteractor;

    /**
     * Constructs a SignUpController with a SignUpInputBoundary.
     *
     * @param userSignUpUseCaseInteractor The interactor handling sign-up use cases.
     */
    public SignUpController(SignUpInputBoundary userSignUpUseCaseInteractor) {
        this.userSignUpUseCaseInteractor = userSignUpUseCaseInteractor;
    }

    /**
     * Executes the sign-up process with provided sign-up details.
     *
     * @param username             The username for the new account.
     * @param password             The password for the new account.
     * @param repeatPassword       The repeated password for confirmation.
     * @param email                The email address for the new account.
     * @param phoneNumber          The phone number for the new account.
     * @param gender               The gender of the user.
     * @param insurance            The insurance details for the new account.
     * @param birthday             The birthday of the user.
     * @param creditCardNumber     The credit card number for payment.
     * @param ccv                  The credit card verification number.
     * @param expirationDate       The expiration date of the credit card.
     * @param nameOnCard           The name on the credit card.
     * @param contactName          The contact name for emergency contact.
     * @param contactPhoneNumber   The phone number for emergency contact.
     * @param contactRelationship  The relationship with the emergency contact.
     */
    public void execute(String username,
                        String password,
                        String repeatPassword,
                        String email,
                        String phoneNumber,
                        String gender,
                        String insurance,
                        Date birthday,
                        String creditCardNumber,
                        int ccv,
                        String expirationDate,
                        String nameOnCard,
                        String contactName,
                        String contactPhoneNumber,
                        String contactRelationship)
    {
        SignUpInputData signUpInputData = new SignUpInputData
                                                  (
                username,
                password,
                repeatPassword,
                email,
                phoneNumber,
                gender,
                insurance,
                birthday,
                creditCardNumber,ccv,expirationDate,nameOnCard,
                contactName,contactPhoneNumber,contactRelationship
                                                  );

        userSignUpUseCaseInteractor.execute(signUpInputData);
    }
}
