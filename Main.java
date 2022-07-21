import java.util.Scanner;

class InvalidShapeException extends Exception {
    public InvalidShapeException() {
        super("Invalid shape entered");
    }
}

class AreaCalculator {
    String shape;
    Scanner scanner = new Scanner(System.in);

    public AreaCalculator(String givenShape) {
        shape = givenShape;
    }

    private double circleArea(int radius) {
        return Math.PI * (radius * radius);
    }

    private double squareArea(int side) {
        return side * side;
    }

    public double calculate() throws InvalidShapeException {
        if (shape.equals("circle")) {
            System.out.println("Enter radius:");
            int radius = scanner.nextInt();
            return circleArea(radius);
        } else if (shape.equals("square")) {
            System.out.println("Enter side length:");
            int side = scanner.nextInt();
            return squareArea(side);
        } else {
            throw new InvalidShapeException();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shape (circle, square):");
        String shape = scanner.nextLine();
        AreaCalculator calculator = new AreaCalculator(shape);
        try {
            double area = calculator.calculate();
            System.out.println("Area: " + area);
        } catch (InvalidShapeException e) {
            System.out.println("Invalid shape type!");
        }
    }
}