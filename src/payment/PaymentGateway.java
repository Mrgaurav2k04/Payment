package payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentGateway {
    // Store all transactions using a HashMap (Transaction ID -> Transaction object)
    private Map<String, Transaction> transactionHistory = new HashMap<>();

    public Transaction processOrder(PaymentMethod method, double amount) {
        System.out.println("\n--- Initiating New Transaction ---");
        Transaction tx = new Transaction(amount);
        System.out.println("Transaction " + tx.getId() + " created. Status: " + tx.getStatus());

        try {
            method.pay(amount);
            tx.markSuccess();
            System.out.println("Payment Successful!");
        } catch (Exception e) {
            tx.markFailed();
            System.out.println("Payment Failed: " + e.getMessage());
        }

        // Save the transaction to the HashMap
        transactionHistory.put(tx.getId(), tx);

        System.out.println("Final Status: " + tx.getStatus());
        System.out.println("----------------------------------\n");

        return tx;
    }

    // Method to find a transaction by its ID using the HashMap
    public void printTransactionDetails(String transactionId) {
        if (transactionHistory.containsKey(transactionId)) {
            Transaction tx = transactionHistory.get(transactionId);
            System.out.println("\n--- Transaction Details ---");
            System.out.println("ID: " + tx.getId());
            System.out.println("Amount: $" + tx.getAmount());
            System.out.println("Status: " + tx.getStatus());
            System.out.println("---------------------------\n");
        } else {
            System.out.println("\nTransaction with ID '" + transactionId + "' not found.\n");
        }
    }
}
