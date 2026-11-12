package ejerBD;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        Leer leer = new Leer();
        Insertar insertar = new Insertar();
        Modificar modificar = new Modificar();
        Eliminar eliminar = new Eliminar();

        do {
            System.out.println("=============================");
            System.out.println("      MENU CRUD ALUMNOS      ");
            System.out.println("=============================");
            System.out.println("1. Mostrar alumnos (Leer)");
            System.out.println("2. Agregar alumno (Insertar)");
            System.out.println("3. Modificar alumno (Update)");
            System.out.println("4. Eliminar alumno (Delete)");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");

            try {
                opcion = entrada.nextInt();
            } catch (Exception e) {
                entrada.nextLine();
                System.out.println("Opcion no valida.\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    leer.leerTabla();
                    break;
                case 2:
                    insertar.ins();
                    break;
                case 3:
                    modificar.mod();
                    break;
                case 4:
                    eliminar.eli();
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion incorrecta.\n");
            }
        } while (opcion != 5);
    }
}
