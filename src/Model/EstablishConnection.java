package Model;
import java.sql.*;
public class EstablishConnection {
    private static Connection con;
    private EstablishConnection(){
    }
    public static Connection getDbConnection(){
        if(con==null){
            try {
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shoe", "root", "root");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return con;
    }
}
