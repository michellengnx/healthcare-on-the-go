package entities.factories.user;

import entities.CreditCard;
import entities.EmergencyContact;
import entities.Patient;
import entities.User;

import java.util.Date;

//This use case will be handling only Patient type of user for now
public class UserFactory {
    public User create(
            String username,
            String password,
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
            String contactRelationship
            ) {

        return new Patient(
                username,
                password,
                email,
                phoneNumber,
                gender,
                insurance,
                birthday,
                new CreditCard(creditCardNumber,ccv,expirationDate,nameOnCard),
                new EmergencyContact(contactName,contactPhoneNumber,contactRelationship));
    }
}
