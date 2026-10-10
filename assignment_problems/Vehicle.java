import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0; // ₹10 per hour
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // ₹30 for 1st hour + ₹20 per additional hour
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        // ₹50 per hour with minimum ₹100
        return Math.max(100.0, hours * 50.0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String vehicleType = scanner.next();
            int hours = scanner.nextInt();

            Vehicle vehicle;
            switch (vehicleType) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                case "TRUCK":
                    vehicle = new Truck(hours);
                    break;
                default:
                    continue;
            }

            double charge = vehicle.calculateCharge();
            grandTotal += charge;

            System.out.printf("%s: %.2f%n", vehicleType, charge);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}