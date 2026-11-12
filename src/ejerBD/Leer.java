package ejerBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Leer {
    public void leerTabla() {
        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();
            PreparedStatement ps = conexion.prepareStatement("select * from alumno");
            ResultSet rs = ps.executeQuery();

            int band = 0;
            while (rs.next()) {
                band = 1;
                System.out.println(" Codigo: " + rs.getInt("id") +
                                   "\n Nombre: " + rs.getString("nombre") +
                                   "\n Apellido: " + rs.getString("apellido") +
                                   "\n Edad: " + rs.getInt("edad") + "\n");
            }

            if (band == 0) {
                System.out.println("No existen registros.\n");
            }

            conexion.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
