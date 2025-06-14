package bibliotecaduoc;


public class Libro {

    // Atributos
    private int indiceLibro;
    private String nombre;
    private String autor;
    private Boolean disponible = true;
    
    //
    public boolean isDisponible() {
    return disponible;
    }

    // Constructor
    public Libro(int indiceLibro, String nombre, String autor, Boolean disponible) {
        this.indiceLibro = indiceLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.disponible = disponible;
    }

    // Getters
    public int getIndiceLibro() {
        return indiceLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    // Setters
    public void setIndiceLibro(int indiceLibro) {
        this.indiceLibro = indiceLibro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

}
