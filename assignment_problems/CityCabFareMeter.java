import java.util.Scanner;

interface NightServiceable {
    double applyNightSurcharge(double fare);
}

abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRatePerKm();

    public double calculateBaseFare() {
        double fare = km * getRatePerKm();
        return Math.max(fare, 100.0);
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }
}

class SuvCab extends Cab implements NightServiceable {
    public SuvCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalFare = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = null;
            switch (cabType.toUpperCase()) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SuvCab(km);
                    break;
            }

            if (cab != null) {
                if (time.equalsIgnoreCase("NIGHT") && !(cab instanceof NightServiceable)) {
                    System.out.println(cabType.toUpperCase() + ": night service not available");
                } else {
                    double fare = cab.calculateBaseFare();
                    if (time.equalsIgnoreCase("NIGHT") && cab instanceof NightServiceable) {
                        fare = ((NightServiceable) cab).applyNightSurcharge(fare);
                    }
                    totalFare += fare;
                    System.out.printf("%s: %.2f%n", cabType.toUpperCase(), fare);
                }
            }
        }
        System.out.printf("Total: %.2f%n", totalFare);
        scanner.close();
    }
}