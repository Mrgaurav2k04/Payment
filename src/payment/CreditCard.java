package payment;

public class CreditCard extends Card {
    private String cvv;

    public CreditCard(String cardNumber, String cardHolderName, String cvv) {
        super(cardNumber, cardHolderName);
        this.cvv = cvv;
    }

    @Override
    protected boolean checkValid() {
        return super.checkValid() && cvv != null && (cvv.length() == 3 || cvv.length() == 4);
    }

    @Override
    public void pay(double amount) {
        if (checkValid()) {
            System.out.println("Processing credit card payment of $" + amount + " for " + cardHolderName);
            System.out.println("Connecting to Visa/Mastercard network...");
        } else {
            throw new IllegalArgumentException("Invalid Credit Card Details.");
        }
    }
}
