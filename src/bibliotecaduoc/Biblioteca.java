package bibliotecaduoc;

import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> libros = new ArrayList<>();

    public Biblioteca() {
        libros.add(new Libro("LAS AVENTURAS DE DUCO", "CRISTO JESUS", true));
        libros.add(new Libro("EL QUIJOTE","CERVANTES", true));
        libros.add(new Libro("ASÍ HABLÓ ZARATRUSTRA","FEDERICO NIETZSCHE", true));
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}