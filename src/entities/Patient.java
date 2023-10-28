package org.example.src.entities;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    private CreditCard creditCard;
    private EmergencyContact emergencyContact;
    private ArrayList<Request> requests;

    public Patient(String username, String password, String email, String phoneNumber, String gender, String insurance, Date birthday, CreditCard creditCard, EmergencyContact emergencyContact) {
        super(username, password, email, phoneNumber, gender, insurance, birthday);
        this.creditCard = creditCard;
        this.emergencyContact = emergencyContact;
        this.requests = new ArrayList<Request>();
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }
}
