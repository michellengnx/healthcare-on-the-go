package org.example.src.entities;

public class creditCard {
    private String creditCardNumber;
    private int ccv;
    private String expirationDate;
    private String nameOnCard;


    //Constructor for credit card set csv
    public creditCard(String creditCardNumber,int cvv, String expirationDate, String nameOnCard){
        this.creditCardNumber = creditCardNumber;
        this.ccv = cvv;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
    }

    //Getters
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getCcv() {
        return ccv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
    //Setters
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
