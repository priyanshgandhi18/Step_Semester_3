import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee1(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10; // 10% of monthly salary
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05; // 5% of monthly salary
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 500.0; // Fixed ₹500 bonus
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        double totalBonus = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            Employee1 emp;
            switch (type) {
                case "FULLTIME":
                    emp = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    emp = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    emp = new InternEmployee(name, salary);
                    break;
                default:
                    continue;
            }

            double bonus = emp.calculateBonus();
            totalBonus += bonus;

            System.out.printf("%s: %.2f%n", emp.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        scanner.close();
    }
}