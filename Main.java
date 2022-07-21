import java.util.Scanner;
import java.io.*;
import java.net.*;

interface Demonstration {
    void announceName();
    void demonstrate(); // require they all have this method
}

class ApiDemonstration implements Demonstration {
    static String getName() {
        return "API Demonstration";
    }

    public void announceName() {
        System.out.println("~~~ " + getName() + " ~~~");
    }

    String buildJson(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int pointer;
        while ((pointer = reader.read()) != -1) {
            sb.append((char) pointer);
        }
        return sb.toString();
    }

    public void demonstrate() {
        try {
            String apiUrl = "https://restcountries.com/v3.1/alpha/US";
            InputStream input = new URL(apiUrl).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String jsonText = buildJson(reader);
            System.out.println(jsonText);
            // I would like to convert it to a JSON object but this requires a 
            // third party library!
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileWriteDemonstration implements Demonstration {
    static String getName() {
        return "File writer";
    }

    public void announceName() {
        System.out.println("*** " + getName() + " ***");
    }

    public void demonstrate() {
        announceName();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line to save to file:");
        String text = scanner.nextLine();
        try {
            FileWriter file = new FileWriter("file.txt");
            file.write(text);
            file.close();
        } catch (IOException e) {
            System.out.println("There was a problem writing to the file.");
            e.printStackTrace();
        }
    }
}

class AreaDemonstration implements Demonstration {
    static String getName() {
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
    public static void main(String[] args) throws Exception {
        System.out.println("Pick a demonstration:");
        System.out.println("(1) " + AreaDemonstration.getName());
        System.out.println("(2) " + FileWriteDemonstration.getName());
        System.out.println("(3) " + ApiDemonstration.getName());

        Scanner scanner = new Scanner(System.in);
        final int CHOICE_COUNT = 3;
        int choice = scanner.nextInt();
        if (choice < 1 || choice > CHOICE_COUNT) {
            throw new Exception("Invalid number");
        } else {
            if (choice == 1) {
                AreaDemonstration demo = new AreaDemonstration();
                demo.demonstrate();
            } else if (choice == 2) {
                FileWriteDemonstration demo = new FileWriteDemonstration();
                demo.demonstrate();
            } else if (choice == 3) {
                ApiDemonstration demo = new ApiDemonstration();
                demo.demonstrate();
            }
        }
    }
}