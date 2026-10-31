interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double getTuitionFee();

    public double calculateTotalFee() {
        double fee = getTuitionFee();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }

    public String getName() {
        return name;
    }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 40000.0 + 60000.0; // tuition + hostel fee
    }
}

class ScholarshipStudent extends Student implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double getTuitionFee() {
        return 20000.0; // half of normal tuition
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String typeWord1 = scanner.next();
            String typeWord2 = "";
            if (typeWord1.equals("DAY")) {
                typeWord2 = scanner.next(); // SCHOLAR
            }
            String type = typeWord1 + (typeWord2.isEmpty() ? "" : "_" + typeWord2);
            String name = scanner.next();

            Student student = null;
            switch (type.toUpperCase()) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
            }

            if (student != null) {
                double fee = student.calculateTotalFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f%n", student.getName(), fee);
            }
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}