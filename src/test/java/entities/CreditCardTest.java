package entities;

import org.junit.Test;

public class CreditCardTest {
    @Test
    public void testCreditCardConstructor() {
        CreditCard creditCard = new CreditCard(
                "000000000000",
                123,
                "Tomorrow",
                "Michelle N"
        );
        assert creditCard.getCreditCardNumber().equals("000000000000");
        assert creditCard.getCcv() == 123;
        assert creditCard.getNameOnCard().equals("Michelle N");
        assert creditCard.getExpirationDate().equals("Tomorrow");


    }
}
