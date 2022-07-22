package demonstration;
import java.util.Scanner;
import exceptions.*;
import calculator.*;

public class AreaDemonstration implements Demonstration {
    public static String getName() {
        return "Area calculator";
    }

    public void announceName() {
        System.out.println("=== " + getName() + " ===");
    }

    public void demonstrate() {
        announceName();
        System.out.println("Enter shape (circle, square):");
        Scanner scanner = new Scanner(System.in);
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