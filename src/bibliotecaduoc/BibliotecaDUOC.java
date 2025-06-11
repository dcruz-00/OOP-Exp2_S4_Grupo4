package bibliotecaduoc;

import java.util.Scanner;

public class BibliotecaDUOC {

    private final Scanner scanner = new Scanner(System.in);
    static String[] opcionesMenu = {
        "1) Registro de usuario",
        "2) Libros Disponibles",
        "3) Prestamo de libros",
        "4) Generar informe",
        "5) Cerrar sesión"
    };

    public static void main(String[] args) {

        BibliotecaDUOC app = new BibliotecaDUOC();
        app.ejecutarMenu();

    }

    private void ejecutarMenu() {
        int opcionMenu = -1;
        System.out.println("Bienvenido al sistema de de préstamo de la Biblioteca de DUOC UC.");
        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opcionMenu = scanner.nextInt();
                scanner.nextLine();
                switch (opcionMenu) {
                    case 1 -> 
                    registrarUsuario();
                    case 2 ->
                    mostrarLibros();    
                    case 3 ->
                    prestamoLibros();    
                    case 4 ->
                    generarInforme();    
                    case 5 ->
                    System.out.println("Saliendo...........");
                }

            }
        } while (opcionMenu != 5);

    }

    private void mostrarMenu() {
        System.out.println("MENU PRINCIPAL");
        for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println(opcionesMenu[i]);                    
        }
        System.out.println("Seleccione una opción: ");
    }

    private void registrarUsuario() {
    
    }
    
    private void mostrarLibros() {
    
    }
    
    private void prestamoLibros() {
    
    }
    
    private void generarInforme() {
    
    }
    
    
}
