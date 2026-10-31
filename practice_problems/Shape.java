java.util.Scanner;

abstract class Shape {
    protected String owner;

    public Shape(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();
    public abstract String getShapeType();

    public String getOwner() {
        return owner;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShapeType() {
        return "CIRCLE";
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getShapeType() {
        return "RECTANGLE";
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShapeType() {
        return "TRIANGLE";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String owner = scanner.next();
            Shape shape = null;

            if (type.equalsIgnoreCase("CIRCLE")) {
                double radius = scanner.nextDouble();
                shape = new Circle(owner, radius);
            } else if (type.equalsIgnoreCase("RECTANGLE")) {
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                shape = new Rectangle(owner, length, width);
            } else if (type.equalsIgnoreCase("TRIANGLE")) {
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                shape = new Triangle(owner, base, height);
            }

            if (shape != null) {
                double area = shape.calculateArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f\n", shape.getOwner(), shape.getShapeType(), area);
            }
        }

        System.out.printf("Total Area: %.2f\n", totalArea);
        scanner.close();
    }
}