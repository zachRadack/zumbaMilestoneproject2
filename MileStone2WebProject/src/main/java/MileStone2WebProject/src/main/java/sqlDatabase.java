package MileStone2WebProject.src.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class sqlDatabase {

    static Connection con;

    static {
        try {
            System.out.println("Attempting a connection to database");
            DriverManager.registerDriver(new Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zachsdb", "root", "y*LQfDN*xz6hkf+Bjt");
            System.out.println("Connection to database successful");
        } catch (SQLException e) {
            System.err.println("Failed to connect to database in sqlDatabase.java");
            System.err.println(e);
        }
    }

    public static Connection getDbConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zachsdb", "root", "y*LQfDN*xz6hkf+Bjt");
            }
            return con;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
}
