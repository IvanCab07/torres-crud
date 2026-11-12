package ejerBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/escuela";
    public static final String usuario = "root";
    public static final String contraseña = "";

    public Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, usuario, contraseña);
        } catch (Exception ex) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, usuario, contraseña);
            } catch (Exception e) {
                System.out.println("Error de conexion: " + e.getMessage());
            }
        }
        return conexion;
    }
}
