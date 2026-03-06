package payment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentGateway gateway = new PaymentGateway();

        System.out.println("Welcome to the Dynamic Payment System!");

        System.out.print("Please enter your Name to create a Client profile: ");
        String clientName = scanner.nextLine().trim();
        System.out.print("Please enter your Email: ");
        String clientEmail = scanner.nextLine().trim();

        Client client = new Client(clientName, clientEmail);
        System.out.println("\nWelcome, " + client.getName() + "! Let's process some payments.");

        while (true) {
            System.out.println("\n--- Select an Option ---");
            System.out.println("1. Pay with Credit Card");
            System.out.println("2. Pay with UPI");
            System.out.println("3. Pay with Wallet");
            System.out.println("4. Look up past Transaction by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("5")) {
                System.out.println("Exiting the payment system. Have a great day!");
                break;
            }

            if (choice.equals("4")) {
                System.out.print("Enter the Transaction ID to look up: ");
                String lookupId = scanner.nextLine().trim();
                gateway.printTransactionDetails(lookupId);
                continue;
            }

            System.out.print("Enter the payment amount: $");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount entered. Please try again.");
                continue;
            }

            PaymentMethod method = null;

            if (choice.equals("1")) {
                System.out.print("Enter your 16-digit Card Number: ");
                String cardNumber = scanner.nextLine().trim();

                System.out.print("Enter Cardholder Name: ");
                String cardHolderName = scanner.nextLine().trim();

                System.out.print("Enter CVV (3 or 4 digits): ");
                String cvv = scanner.nextLine().trim();

                method = new CreditCard(cardNumber, cardHolderName, cvv);

            } else if (choice.equals("2")) {
                System.out.print("Enter your UPI ID (e.g., user@bank): ");
                String upiId = scanner.nextLine().trim();

                method = new UPI(upiId);

            } else if (choice.equals("3")) {
                System.out.print("Enter your Wallet Phone Number: ");
                String phoneNumber = scanner.nextLine().trim();

                method = new Wallet(phoneNumber);

            } else {
                System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 5.");
                continue;
            }

            // Process the dynamically created payment method
            gateway.processOrder(method, amount);
        }

        scanner.close();
    }
}
