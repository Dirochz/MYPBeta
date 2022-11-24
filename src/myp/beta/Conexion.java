package myp.beta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectar(){
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bdatos", "root", "");
            return c;          
        }catch(SQLException e){
            System.out.println("soy yo conexion");
        }
        return (null);
    }
}
