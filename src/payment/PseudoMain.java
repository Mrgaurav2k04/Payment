package payment;

abstract class MakePayment {
    abstract void pay(double amount);
}

class CardPayment extends MakePayment {
    String name;
    String cardNumber;
    String cardType;

    public CardPayment(String name, String cardNumber, String cardType) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    @Override
    public void pay(double amount) {
        System.out.println("User: " + name);
        System.out.println(cardType + " Card Number: " + cardNumber);
        System.out.println("Payment of " + amount + " made using " + cardType + " Card");
    }
}

class UPIPayment extends MakePayment {
    String name;
    String upiId;

    public UPIPayment(String name, String upiId) {
        this.name = name;
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("User: " + name);
        System.out.println("UPI ID: " + upiId);
        System.out.println("Payment of " + amount + " made using UPI");
    }
}

public class PseudoMain {
    public static void main(String[] args) {
        MakePayment payment1;
        MakePayment payment2;
        MakePayment payment3;

        payment1 = new CardPayment("Aditya", "1234567890123456", "Credit");
        payment1.pay(1000);

        payment2 = new CardPayment("Aditya", "9876543210987654", "Debit");
        payment2.pay(500);

        payment3 = new UPIPayment("Aditya", "aditya@upi");
        payment3.pay(200);
    }
}
