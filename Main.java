import java.util.Scanner;
import demonstration.*;

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