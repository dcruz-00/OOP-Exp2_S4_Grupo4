package bibliotecaduoc;

import java.util.HashMap;

public class Usuario {
    private String rut;
    private String nombre;
    private String apellidoPaterno; 
    private String apellidoMaterno; 
    
    HashMap<String, String> usuarios = new HashMap<>();

    // c
    public Usuario(String rut, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    // g
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public HashMap<String, String> getUsuarios() {
        return usuarios;
    }

    // s
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setUsuarios(HashMap<String, String> usuarios) {
        this.usuarios = usuarios;
    }
    
}
