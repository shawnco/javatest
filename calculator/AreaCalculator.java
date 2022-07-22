package calculator;
import java.util.Scanner;
import exceptions.*;

public class AreaCalculator {
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