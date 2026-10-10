import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30); // Valid for 30 days
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90); // Valid for 90 days
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365); // Valid for 365 days
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String planType = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();

            LocalDate startDate = LocalDate.parse(dateStr, formatter);
            SubscriptionPlan plan;

            switch (planType) {
                case "BASIC":
                    plan = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    plan = new StandardPlan(name, startDate);
                    break;
                case "PREMIUM":
                    plan = new PremiumPlan(name, startDate);
                    break;
                default:
                    continue;
            }

            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.printf("%s: %s%n", plan.getName(), renewalDate.format(formatter));
        }

        scanner.close();
    }
}