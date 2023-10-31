package org.example.src.entities;
import entities.CreditCard;
import entities.ServiceRequest;
import entities.EmergencyContact;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends org.example.src.entities.User {
    private CreditCard creditCard;
    private EmergencyContact emergencyContact;
    private ArrayList<ServiceRequest> requests;
    private String insurance;

    public Patient(String username, String password, String email, String phoneNumber, String gender, String insurance, Date birthday, CreditCard creditCard, EmergencyContact emergencyContact) {
        super(username, password, email, phoneNumber, gender, birthday);
        this.creditCard = creditCard;
        this.insurance = insurance;
        this.emergencyContact = emergencyContact;
        this.requests = new ArrayList<ServiceRequest>();
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public ArrayList<ServiceRequest> getRequests() {
        return requests;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setRequests(ArrayList<ServiceRequest> requests) {
        this.requests = requests;
    }
}
