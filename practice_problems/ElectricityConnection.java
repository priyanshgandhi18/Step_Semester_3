import java.util.Scanner;

abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double totalBill = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            ElectricityConnection connection = null;

            if (type.equalsIgnoreCase("HOME")) {
                connection = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                connection = new ShopConnection(units);
            } else if (type.equalsIgnoreCase("FACTORY")) {
                connection = new FactoryConnection(units);
            }

            if (connection != null) {
                double bill = connection.calculateBill();
                totalBill += bill;
                System.out.printf("%s: %.2f\n", connection.getType(), bill);
            }
        }

        System.out.printf("Total: %.2f\n", totalBill);
        scanner.close();
    }
}