package payment;

public class UPI implements PaymentMethod {
    private String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of $" + amount);
        System.out.println("Sending collect request to " + upiId + "...");
    }
}
