package database;
import java.sql.*;
import java.io.*;
import java.util.Properties;

public class Database {
    Connection con;
    Properties props;

    public Database() throws ClassNotFoundException, SQLException {
        props = getProperties();
        Class.forName(props.getProperty("db.driver"));
        con = DriverManager.getConnection(props.getProperty("db.path"), props.getProperty("db.user"), props.getProperty("db.password"));
    }

    public Properties getProperties() {
        try {
            InputStream input = new FileInputStream("database/config.properties");
            Properties props = new Properties();
            props.load(input);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getEmployees() throws SQLException {
        String query = "SELECT * FROM Employees";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }

    public void listEmployees(ResultSet employees) throws SQLException {
        while (employees.next()) {
            String fname = employees.getString("first");
            String lname = employees.getString("last");
            System.out.println(fname + " " + lname);
        }
    }
}
