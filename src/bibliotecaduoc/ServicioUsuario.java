package bibliotecaduoc;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;

public class ServicioUsuario {

    private final Scanner scanner = new Scanner(System.in);
    HashMap<String, String> usuarios = new HashMap<>();
    ArrayList<Libro> libros = new ArrayList<>();
    
    
    public void registrarUsuario() {
        System.out.println("\n=== REGISTRAR USUARIO ===");

        String rut;
        Pattern patronRut = Pattern.compile("^[0-9]{1,2}\\.[0-9]{3}\\.[0-9]{3}-[0-9Kk]$");

        while (true) {
            System.out.println("\nIngrese su RUT (formato: XX.XXX.XXX-X): ");
            rut = scanner.nextLine().trim();

            if (!patronRut.matcher(rut).matches()) {
                System.out.println("\nFormato de RUT inválido. Use puntos y guión (XX.XXX.XXX-X)");
                continue;
            }

            if (usuarios.containsKey(rut)) {
                System.out.println("\nEste RUT ya estpa registrado. Intente con otro.");
                continue;
            }

            break;
        }

        String nombre = validarYCapitalizar("\nIngrese su nombre:");
        String apellidoPaterno = validarYCapitalizar("\nIngrese su apellido paterno:");
        String apellidoMaterno = validarYCapitalizar("\nIngrese su apellido materno");

        String nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
        // Se agrega al HashMap
        usuarios.put(rut, nombreCompleto);
        System.out.println("\n¡Gracias por ser parte de nuestra biblioteca " + nombreCompleto + ", [" + rut + "]!");
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


    
    public void prestamoLibros() {         
        
        System.out.println("\n=== PRESTAMO DE LIBROS ===");
        System.out.println("\nPorfavor, ingrese su RUT (formato: XX.XXX.XXX-X):");
        String rut = scanner.nextLine().trim();

        if (!usuarios.containsKey(rut)) {
            System.out.println("\nEl RUT ingresado no esta registrado.");
            System.out.println("Debe registrarse antes de pedir un préstamo.");
            return;
        }

        String nombre = usuarios.get(rut);
        System.out.println("\n¡Bienvenido(a), " + nombre + ". Puede continuar con el préstamo.");

        System.out.println("Por favor, a continuación elija su libro según su código #.");
        int opcionLibro = scanner.nextInt();
        scanner.nextLine();
            
        boolean libroEncontrado = false;

        for (Libro libro : libros) {
            
            
            if (libro.getIndiceLibro() == opcionLibro) {
                libroEncontrado = true;
                if (libro.isDisponible()) {
                    libro.setDisponible(false);
                    System.out.println("Libro elegido: " + libro.getNombre());
                }
            } else { //arreglar
                System.out.println("El libro que eligió no está disponible.");
            }
            break;
        }

        if (!libroEncontrado) {
            System.out.println("No se encontró libro con el código ingresado.");
        }
    }

}
