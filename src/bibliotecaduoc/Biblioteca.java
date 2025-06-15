package bibliotecaduoc;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private final Scanner scanner = new Scanner(System.in);
    ArrayList<Libro> libros = new ArrayList<>();

    public Biblioteca() {
        libros.add(new Libro(1, "Las Aventuras de Duco", "Emilia Acevedo", true));
        libros.add(new Libro(2, "El Quijote", "Cervantes", true));
        libros.add(new Libro(3, "Así habló Zaratrustra", "Federico Nietzsche", true));
        libros.add(new Libro(4, "El Extranjero", "Albert Camus", true));
        libros.add(new Libro(5, "Noches Blancas", "Fiodor Dostoyevsky", true));
        libros.add(new Libro(6, "Ficciones", "Jorge Luis Borges", true));
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }   

    public void mostrarLibros() {
        System.out.println("\n=== LISTA DE LIBROS DISPONIBLES ===");
        for (Libro libro : libros) {
            System.out.println("------------------------");
            System.out.println("NOMBRE: " + libro.getNombre());
            System.out.println("AUTOR: " + libro.getAutor());
            System.out.println("CÓDIGO PARA PRESTAMO: #" + libro.getIndiceLibro());
            System.out.println("DISPONIBILIDAD: " + (libro.isDisponible() ? "Disponible" : "No Disponible"));
        }
    }

    public void prestamoLibros() {
        System.out.println("\n=== PRESTAMO DE LIBROS ===");
        System.out.println("\nPor favor, ingrese su RUT (formato: XX.XXX.XXX-X):");
        String rut = scanner.nextLine().trim();

        if (!Usuario.existeUsuario(rut)) {
            System.out.println("El RUT ingresado no está registrado.");
            System.out.println("Debe registrarse antes de pedir un préstamo.");
            return;
        }

        Usuario usuario = Usuario.obtenerUsuario(rut);
        System.out.println("¡Bienvenido(a), " + usuario.getNombreCompleto() + ". Puede continuar con el préstamo.");

        System.out.println("Por favor, a continuación elija su libro según su código #.");        
        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Debe ingresar un número de código.");
            scanner.nextLine();
            return;
        }        
        int opcionLibro = scanner.nextInt();
        scanner.nextLine();

        boolean libroEncontrado = false;
        for (Libro libro : libros) {
            if (libro.getIndiceLibro() == opcionLibro) {
                libroEncontrado = true;
                if (libro.isDisponible()) {
                    libro.prestarA(rut);
                    usuario.agregarLibroPrestado(libro);
                    System.out.println("Libro elegido: " + libro.getNombre() + ". Ahora está en préstamo a: " + usuario.getNombreCompleto());
                } else { //se arreglan llaves que no permitían el correcto flujo del código
                    System.out.println("El libro que eligió no está disponible.");
                }
                break;
            }
        }
        if (!libroEncontrado) {
            System.out.println("No se encontró libro con el código ingresado.");
        }
    }

    public void generarInforme() { //completar.

    }

}
