package payment;

import java.util.UUID;

public class Transaction {
    private String id;
    private double amount;
    private String status;

    public Transaction(double amount) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.status = "PENDING";
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public void markSuccess() {
        if ("FAILED".equals(status)) {
            System.out.println("ERROR: Cannot mark a failed transaction as successful.");
        } else {
            this.status = "SUCCESS";
        }
    }

    public void markFailed() {
        this.status = "FAILED";
    }
}
