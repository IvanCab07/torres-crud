package ejerBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Eliminar {
    public void eli() {
        Scanner entrada = new Scanner(System.in);

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            System.out.print("Ingrese el código del alumno a eliminar: ");
            int cod = entrada.nextInt();

            PreparedStatement ps = conexion.prepareStatement("select * from alumno where id = ?");
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(" Codigo: " + rs.getInt("id") +
                                   "\n Nombre: " + rs.getString("nombre") +
                                   "\n Apellido: " + rs.getString("apellido") +
                                   "\n Edad: " + rs.getInt("edad") + "\n");

                ps = conexion.prepareStatement("delete from alumno where id = ?");
                ps.setInt(1, cod);

                int resultado = ps.executeUpdate();
                if (resultado > 0) {
                    System.out.println("Alumno eliminado con exito.\n");
                }
            } else {
                System.out.println("No existe el registro.\n");
            }

            conexion.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
