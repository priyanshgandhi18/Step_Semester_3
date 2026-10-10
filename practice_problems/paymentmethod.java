import java.util.Scanner;

abstract class PaymentMethod {
    public abstract double calculateAdjustedAmount(double amount);
}

class CardPayment extends PaymentMethod {
    @Override
    public double calculateAdjustedAmount(double amount) {
        return amount * 1.02; // 2% fee
    }
}

class WalletPayment extends PaymentMethod {
    @Override
    public double calculateAdjustedAmount(double amount) {
        return amount * 1.01; // 1% fee
    }
}

class BankTransferPayment extends PaymentMethod {
    @Override
    public double calculateAdjustedAmount(double amount) {
        return amount; // 0% fee
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            PaymentMethod payment;
            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransferPayment();
                    break;
                default:
                    continue;
            }

            double adjustedAmount = payment.calculateAdjustedAmount(amount);
            grandTotal += adjustedAmount;

            System.out.printf("%s: %.2f%n", type, adjustedAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}