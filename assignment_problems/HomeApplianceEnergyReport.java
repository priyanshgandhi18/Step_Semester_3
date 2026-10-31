import java.util.Scanner;

interface SaverMode {
    double applySaverMode(double units);
}

abstract class Appliance {
    protected double hours;
    protected boolean isSaver;

    public Appliance(double hours, boolean isSaver) {
        this.hours = hours;
        this.isSaver = isSaver;
    }

    public abstract double getPowerRating(); // in Watts

    public double calculateUnits() {
        double units = (getPowerRating() * hours) / 1000.0;
        if (isSaver && this instanceof SaverMode) {
            units = ((SaverMode) this).applySaverMode(units);
        }
        return units;
    }

    public boolean isSaverRequested() {
        return isSaver;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean isSaver) {
        super(hours, isSaver);
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours, boolean isSaver) {
        super(hours, isSaver);
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }

    @Override
    public double applySaverMode(double units) {
        return units * 0.75; // reduced by 25%
    }
}

class TV extends Appliance {
    public TV(double hours, boolean isSaver) {
        super(hours, isSaver);
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine(double hours, boolean isSaver) {
        super(hours, isSaver);
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }

    @Override
    public double applySaverMode(double units) {
        return units * 0.75; // reduced by 25%
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String appName = scanner.next();
            double hours = scanner.nextDouble();
            boolean saver = false;
            if (scanner.hasNext("SAVER")) {
                saver = true;
                scanner.next();
            }

            Appliance appliance = null;
            switch (appName.toUpperCase()) {
                case "FRIDGE":
                    appliance = new Fridge(hours, saver);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours, saver);
                    break;
                case "TV":
                    appliance = new TV(hours, saver);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours, saver);
                    break;
            }

            if (appliance != null) {
                if (saver && !(appliance instanceof SaverMode)) {
                    System.out.println(appName.toUpperCase() + ": saver mode not supported");
                } else {
                    double units = appliance.calculateUnits();
                    double cost = units * 8.0;
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", appName.toUpperCase(), units, cost);
                }
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}