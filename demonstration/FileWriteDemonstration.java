package demonstration;
import java.util.Scanner;
import java.io.*;

public class FileWriteDemonstration implements Demonstration {
    public static String getName() {
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