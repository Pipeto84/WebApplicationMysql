/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conectores;

/**
 *
 * @author felipe
 */
import java.sql.*;
public class JDBCmysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre = args[0];
        int clave = Integer.parseInt(args[1]);
        String user = "root";
        String pass = "Draco#1984";
        String url = "jdbc:mysql://localhost:3306/test";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.getLogger(JDBCmysql.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            statement = conexion.createStatement();
            statement.executeUpdate("insert into users(userName, userPassword) value('"+ nombre +"', "+ clave + ")");
            rs = statement.executeQuery("select * from users");
            rs.next();
            do {
                System.out.println(rs.getInt("userId")+" : "+rs.getString("userName"));
            }while (rs.next());
            
        } catch (SQLException ex) {
            System.getLogger(JDBCmysql.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
}
