package entities;

import java.util.Date;

public class ServiceRequest {
    Date creationTime;
    Doctor doctor;
    int urgencyLevel;
    String destination;
    Service service;
    float price; // calculated using API
    float eta; // calculated using API
    float distance; // calculated using API

    User patient;

    private boolean completed;

    public ServiceRequest(User patient, Date creationTime, Doctor doctor, int urgencyLevel, String destination, Service service, float price, float eta, float distance) {
        this.patient = patient;
        this.creationTime = creationTime;
        this.doctor = doctor;
        this.urgencyLevel = urgencyLevel;
        this.destination = destination;
        this.service = service;
        this.price = price;
        this.eta = eta;
        this.distance = distance;
        this.completed = false;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(int urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getEta() {
        return eta;
    }

    public void setEta(float eta) {
        this.eta = eta;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
