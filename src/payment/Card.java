package payment;

public abstract class Card implements PaymentMethod {
    protected String cardNumber;
    protected String cardHolderName;

    public Card(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    protected boolean checkValid() {
        return cardNumber != null && cardNumber.length() == 16;
    }
}
