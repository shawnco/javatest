package demonstration;
import java.sql.*;
import database.*;

public class DatabaseDemonstration implements Demonstration {
    public static String getName() {
        return "Database access";
    }    

    public void announceName() {
        System.out.println("^^^ " + getName() + " ^^^");
    }

    public void demonstrate() {
        announceName();
        try {
            Database db = new Database();
            ResultSet employees = db.getEmployees();
            db.listEmployees(employees);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }        
    }
}
