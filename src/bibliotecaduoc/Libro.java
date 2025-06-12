package bibliotecaduoc;


public class Libro {

    private String nombre;
    private String autor;
    private Boolean disponible;

    // c
    public Libro(String nombre, String autor, Boolean disponible) {
        this.nombre = nombre;
        this.autor = autor;
        this.disponible = disponible;
    }

    // g
    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public Boolean getDisponible() {
        return disponible;
    }


    // s
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
