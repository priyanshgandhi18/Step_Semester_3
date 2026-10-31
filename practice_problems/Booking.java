import java.util.Scanner;

abstract class Booking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    // Abstract method for mode-specific base fare calculation
    protected abstract double calculateBaseFare();
    public abstract String getMode();

    // Template method to ensure booking fee is added in one place
    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            Booking booking = null;

            if (mode.equalsIgnoreCase("BUS")) {
                booking = new BusBooking(distance);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                booking = new TrainBooking(distance);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                booking = new FlightBooking(distance);
            }

            if (booking != null) {
                System.out.printf("%s: %.2f\n", booking.getMode(), booking.calculateTotalFare());
            }
        }

        scanner.close();
    }
}