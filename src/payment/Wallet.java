package payment;

public class Wallet implements PaymentMethod {
    private String phoneNumber;

    public Wallet(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amount) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid Wallet Phone Number.");
        }
        System.out.println("Processing wallet payment of $" + amount + " for number " + phoneNumber);
        System.out.println("Deducting from wallet balance...");
    }
}
