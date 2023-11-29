package interface_adapter.SignUp;

import use_case.SignUp.SignUpInputBoundary;
import use_case.SignUp.SignUpInputData;

import java.util.Date;

public class SignUpController {
    final SignUpInputBoundary userSignUpUseCaseInteractor;
    public SignUpController(SignUpInputBoundary userSignUpUseCaseInteractor) {
        this.userSignUpUseCaseInteractor = userSignUpUseCaseInteractor;
    }

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
