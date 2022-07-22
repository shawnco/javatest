import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
import demonstration.*;
import database.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Pick a demonstration:");
        System.out.println("(1) " + AreaDemonstration.getName());
        System.out.println("(2) " + FileWriteDemonstration.getName());
        System.out.println("(3) " + ApiDemonstration.getName());
        System.out.println("(4) " + DatabaseDemonstration.getName());

        Scanner scanner = new Scanner(System.in);
        final int CHOICE_COUNT = 4;
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
            } else if (choice == 4) {
                DatabaseDemonstration demo = new DatabaseDemonstration();
                demo.demonstrate();
            }
        }
    }
}