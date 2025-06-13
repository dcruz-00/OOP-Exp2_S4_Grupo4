
package bibliotecaduoc;

import java.util.HashMap;
import java.util.Scanner;


public class BibliotecaDUOC {

    HashMap<String, String> usuarios = new HashMap<>();
    ServicioUsuario servicioUsuario = new ServicioUsuario();
    Biblioteca biblioteca = new Biblioteca();

    private final Scanner scanner = new Scanner(System.in);
    static String[] opcionesMenu = {
        "------------------------",
        "1) Registro de usuario",
        "2) Libros Disponibles",
        "3) Prestamo de libros",
        "4) Generar informe",
        "5) Cerrar sesión",
        "------------------------",
    };

    public static void main(String[] args) {
        BibliotecaDUOC app = new BibliotecaDUOC();
        app.ejecutarMenu();
    }

    public void ejecutarMenu() {
        int opcionMenu = -1;
        System.out.println("..:: ¡Bienvenido al sistema de préstamo de la Biblioteca de DUOC UC! ::..");
        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcionMenu = scanner.nextInt();
                scanner.nextLine();
                switch (opcionMenu) {
                    case 1 ->
                        servicioUsuario.registrarUsuario();
                    case 2 ->
                        biblioteca.mostrarLibros();
                    case 3 ->
                        servicioUsuario.prestamoLibros();
                    case 4 ->
                        generarInforme();
                    case 5 ->
                        System.out.println("Saliendo del Sistema...........");
                }
            }
        } while (opcionMenu != 5);
    }

    public void mostrarMenu() {
        System.out.println("\n==== MENU PRINCIPAL ====");
        for (int i = 0; i < opcionesMenu.length; i++) {
            System.out.println(opcionesMenu[i]);
        }
        System.out.println("Seleccione una opción: ");
    }

    public void generarInforme() {

    }

}
