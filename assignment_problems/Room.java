import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0; // ₹8 per unit
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        // ₹6 per unit, divided equally by number of occupants
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        // ₹10 per unit + ₹200 fixed charge
        return (units * 10.0) + 200.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String roomType = scanner.next();
            int units = scanner.nextInt();

            Room room;
            if (roomType.equals("SHARED")) {
                int occupants = scanner.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (roomType.equals("SINGLE")) {
                room = new SingleRoom(units);
            } else {
                room = new ACRoom(units);
            }

            double billAmount = room.calculateBill();
            grandTotal += billAmount;

            System.out.printf("%s: %.2f%n", roomType, billAmount);
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}