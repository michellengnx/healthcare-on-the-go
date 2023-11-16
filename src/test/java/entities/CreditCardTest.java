package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardTest {
    @Test
    public void testCreditCardConstructor() {
        CreditCard creditCard = new CreditCard(
                "000000000000",
                123,
                "Tomorrow",
                "Michelle N"
        );
        assertEquals("000000000000", creditCard.getCreditCardNumber());
        assertEquals(123,creditCard.getCcv());
        assertEquals("Tomorrow", creditCard.getExpirationDate());
        assertEquals("Michelle N",creditCard.getNameOnCard());


    }
}
