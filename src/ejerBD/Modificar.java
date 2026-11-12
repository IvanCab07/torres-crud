package ejerBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Modificar {
    public void mod() {
        Scanner entrada = new Scanner(System.in);

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            System.out.print("Ingrese el código del alumno a modificar: ");
            int cod = entrada.nextInt();

            PreparedStatement ps = conexion.prepareStatement("select * from alumno where id = ?");
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(" Codigo: " + rs.getInt("id") +
                                   "\n Nombre: " + rs.getString("nombre") +
                                   "\n Apellido: " + rs.getString("apellido") +
                                   "\n Edad: " + rs.getInt("edad") + "\n");

                entrada.nextLine();
                System.out.print("Nuevo nombre: ");
                String nombre = entrada.nextLine();
                System.out.print("Nuevo apellido: ");
                String apellido = entrada.nextLine();
                System.out.print("Nueva edad: ");
                int edad = entrada.nextInt();

                ps = conexion.prepareStatement("update alumno set nombre = ?, apellido = ?, edad = ? where id = ?");
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setInt(3, edad);
                ps.setInt(4, cod);

                int resultado = ps.executeUpdate();
                if (resultado > 0) {
                    System.out.println("Registro modificado con exito.\n");
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
