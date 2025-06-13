package bibliotecaduoc;

import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> libros = new ArrayList<>();

    public Biblioteca() {
        libros.add(new Libro(1, "Las Aventuras de Duco", "Cristo Jesus", true));
        libros.add(new Libro(2, "El Quijote","Cervantes", true));
        libros.add(new Libro(3, "Así habló Zaratrustra","Federico Nietzsche", true));
        libros.add(new Libro(4, "Nombre", "Autor", true ));
        libros.add(new Libro(5, "Nombre", "Autor", true ));
        libros.add(new Libro(6, "Nombre", "Autor", true ));
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
    
    public void mostrarLibros() {
        System.out.println("\n=== LISTA DE LIBROS DISPONIBLES ===");
        for(Libro libro : libros) {
            System.out.println("------------------------");
            System.out.println("NOMBRE: " + libro.getNombre());
            System.out.println("AUTOR: " + libro.getAutor());
            System.out.println("CÓDIGO PARA PRESTAMO: #" + libro.getIndiceLibro());
            System.out.println("DISPONIBILIDAD: " + (libro.getDisponible() ? "Disponible" : "No Disponible"));
        }

    }
}