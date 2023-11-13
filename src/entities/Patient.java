package entities;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    private CreditCard creditCard;
    private EmergencyContact emergencyContact;
    private ArrayList<ServiceRequest> requests;
    private String insurance;

    public Patient(String username, String password, String email, String phoneNumber, String gender, String insurance, Date birthday, CreditCard creditCard, EmergencyContact emergencyContact) {
        super(username, password, email, phoneNumber, gender, birthday);
        this.creditCard = creditCard;
        this.emergencyContact = emergencyContact;
        this.insurance = insurance;
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

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
