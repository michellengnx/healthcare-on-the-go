package entities;

import entities.CreditCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    @Test
    void testCreditCardConstructorAndGetters() {
        // Arrange
        String creditCardNumber = "1234567812345670";
        int ccv = 123;
        String expirationDate = "12/25";
        String nameOnCard = "John Doe";

        // Act
        CreditCard creditCard = new CreditCard(creditCardNumber, ccv, expirationDate, nameOnCard);

        // Assert
        assertEquals(creditCardNumber, creditCard.getCreditCardNumber());
        assertEquals(ccv, creditCard.getCcv());
        assertEquals(expirationDate, creditCard.getExpirationDate());
        assertEquals(nameOnCard, creditCard.getNameOnCard());
    }

    @Test
    void testCreditCardSetters() {
        // Arrange
        CreditCard creditCard = new CreditCard("1234567812345670", 123, "12/25", "John Doe");

        // Act
        String newCreditCardNumber = "9876543210987654";
        int newCcv = 456;
        String newExpirationDate = "01/23";
        String newNameOnCard = "Jane Doe";

        creditCard.setCreditCardNumber(newCreditCardNumber);
        creditCard.setCcv(newCcv);
        creditCard.setExpirationDate(newExpirationDate);
        creditCard.setNameOnCard(newNameOnCard);

        // Assert
        assertEquals(newCreditCardNumber, creditCard.getCreditCardNumber());
        assertEquals(newCcv, creditCard.getCcv());
        assertEquals(newExpirationDate, creditCard.getExpirationDate());
        assertEquals(newNameOnCard, creditCard.getNameOnCard());
    }
}
