package sqldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    private static void init_table(String command){
        Connection conn = ConnectDB.getDBConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(command);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void init_tables(){
        init_table("CREATE TABLE IF NOT EXISTS skupina(id INTEGER PRIMARY KEY AUTOINCREMENT, type VARCHAR(45) UNIQUE);");
        init_table("CREATE TABLE IF NOT EXISTS student(id INTEGER PRIMARY KEY NOT NULL,name VARCHAR(45),lastname VARCHAR(45), birthdate DATE, skupina INTEGER, FOREIGN KEY(skupina) REFERENCES skupina(id));");
        init_table("CREATE TABLE IF NOT EXISTS grade(id INTEGER PRIMARY KEY AUTOINCREMENT, value VARCHAR(45), student INTEGER NOT NULL , CONSTRAINT FKstudent FOREIGN KEY(student) REFERENCES student(id) ON DELETE CASCADE);");
    }
}
