// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy 1 - Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card. Card Number: " + cardNumber);
    }
}

// Concrete Strategy 2 - PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal. Email: " + email);
    }
}

// Concrete Strategy 3 - Cryptocurrency Payment
class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cryptocurrency. Wallet Address: " + walletAddress);
    }
}

// Context Class - Payment Processor
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Main class to test the Strategy pattern
public class Main {
    public static void main(String[] args) {
        // Create payment strategies
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432");
        PaymentStrategy paypal = new PayPalPayment("user@example.com");
        PaymentStrategy crypto = new CryptoPayment("0xABC1234567890");

        // Create context (PaymentProcessor)
        PaymentProcessor paymentProcessor = new PaymentProcessor(creditCard);

        // Use Credit Card Payment
        paymentProcessor.processPayment(100);

        // Change strategy to PayPal and process payment
        paymentProcessor.setPaymentStrategy(paypal);
        paymentProcessor.processPayment(200);

        // Change strategy to Cryptocurrency and process payment
        paymentProcessor.setPaymentStrategy(crypto);
        paymentProcessor.processPayment(500);
    }
}
