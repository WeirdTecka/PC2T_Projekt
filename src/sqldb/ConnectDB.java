package sqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {

    public static volatile Connection DBConnection;
    private ConnectDB() {}

    public static Connection getDBConnection() {
        try {
            String url = "jdbc:sqlite:C:/Users/tecka/Documents/VSCode/proj/src/sqldb/students.db";
            DBConnection = DriverManager.getConnection(url);
            
            System.out.println("Spojeni s databazi bylo navazano.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return DBConnection;
    }
    public static void disconnect() { 
            if (DBConnection != null) {
                   try {     DBConnection.close();  } 
                       catch (SQLException ex) { System.out.println(ex.getMessage()); }
            }
    }
} 