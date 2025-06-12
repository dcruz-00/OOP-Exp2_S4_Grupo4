package bibliotecaduoc;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BibliotecaDUOC {

    HashMap<String, String> usuarios = new HashMap<>();

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
        System.out.println("REGISTRAR USUARIO");

        String rut;
        Pattern patronRut = Pattern.compile("^[0-9]{1,2}\\.[0-9]{3}\\.[0-9]{3}-[0-9Kk]$");
        while (true) {
            System.out.println("\nIngrese su RUT (formato: XX.XXX.XXX-X): ");
            rut = scanner.nextLine().trim();

            if (!patronRut.matcher(rut).matches()) {
                System.out.println("\nFormato de RUT inválido. Use puntos y guión (XX.XXX.XXX-X)");
            }
            break;
        }

        String nombre = validarYCapitalizar("\nIngrese su nombre:");
        String apellidoPaterno = validarYCapitalizar("\nIngrese su apellido paterno:");
        String apellidoMaterno = validarYCapitalizar("\nIngrese su apellido materno");

        String nombreCompleto = nombre + apellidoPaterno + apellidoMaterno;
        usuarios.put(rut, nombreCompleto);
        System.out.println("Usted es " + rut + ", " + nombreCompleto);
    }

    private String validarYCapitalizar(String mensaje) {
        String texto;
        while (true) {
            System.out.println(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")) {
                texto = texto.toLowerCase();
                return texto.substring(0, 1).toUpperCase() + texto.substring(1);
            } else {
                System.out.println("\nEntrada invalida. Solo se permiten letras. Intente nuevamente.");
            }
        }
    }

    private void mostrarLibros() {

    }

    private void prestamoLibros() {

    }

    private void generarInforme() {

    }

}
