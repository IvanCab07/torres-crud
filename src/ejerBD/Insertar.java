package ejerBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insertar {
    public void ins() {
        Scanner entrada = new Scanner(System.in);

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            System.out.println("--- Ingresar nuevo alumno ---");
            System.out.print("Nombre: ");
            String nombre = entrada.nextLine();
            System.out.print("Apellido: ");
            String apellido = entrada.nextLine();
            System.out.print("Edad: ");
            int edad = entrada.nextInt();

            PreparedStatement ps = conexion.prepareStatement("insert into alumno (nombre, apellido, edad) values (?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, edad);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                System.out.println("Alumno registrado con exito.\n");
            } else {
                System.out.println("No se pudo registrar el alumno.\n");
            }

            conexion.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
