package entities;

public class CreditCard {
//   TODO: cc number should not be string
    private String creditCardNumber;
    private int ccv;
//   TODO: expirationDate should not be string
    private String expirationDate;
    private String nameOnCard;


    //Constructor for credit card set cvv
    public CreditCard(String creditCardNumber,int cvv, String expirationDate, String nameOnCard){
        this.creditCardNumber = creditCardNumber;
        this.ccv = cvv;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
    }

    //Getters
    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }

    public int getCcv() {
        return this.ccv;
    }

    public String getNameOnCard() {
        return this.nameOnCard;
    }

    public String getExpirationDate() {
        return this.expirationDate;
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
