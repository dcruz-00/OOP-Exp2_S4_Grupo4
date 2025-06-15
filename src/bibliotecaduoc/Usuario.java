package bibliotecaduoc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    private static final HashMap<String, Usuario> usuarios = new HashMap<>();
    private List<Libro> librosPrestados = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Validaciones validaciones = new Validaciones();

    // Constructor
    private Usuario(String rut, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    // Getter
    public String getRut() {
        return rut;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
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

    public static HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public static void registrarUsuario() {
        System.out.println("\n=== REGISTRAR USUARIO ===");
        String rut;
        Pattern patronRut = Pattern.compile("^[0-9]{1,2}\\.[0-9]{3}\\.[0-9]{3}-[0-9Kk]$");

        while (true) {
            System.out.println("Ingrese su RUT (formato: XX.XXX.XXX-X): ");
            rut = scanner.nextLine().trim();
            if (!patronRut.matcher(rut).matches()) {
                System.out.println("Formato de RUT inválido. Use puntos y guión (XX.XXX.XXX-X).");
                continue;
            }
            if (usuarios.containsKey(rut)) {
                System.out.println("Este RUT ya está registrado. Intente con otro.");
                continue;
            }
            break;
        }

        String nombre = validaciones.validarYCapitalizar("Ingrese su nombre:");
        String apellidoPaterno = validaciones.validarYCapitalizar("Ingrese su apellido paterno:");
        String apellidoMaterno = validaciones.validarYCapitalizar("Ingrese su apellido materno:");

        Usuario nuevo = new Usuario(rut, nombre, apellidoPaterno, apellidoMaterno);
        usuarios.put(rut, nuevo);
        System.out.println("¡Registro exitoso! Bienvenido(a) " + nuevo.getNombreCompleto() + " [" + rut + "].");
    }

    public static boolean existeUsuario(String rut) {
        return usuarios.containsKey(rut);
    }

    public static Usuario obtenerUsuario(String rut) {
        return usuarios.get(rut);
    }

    public static Map<String, Usuario> listarUsuarios() {
        return usuarios;
    }

    public void agregarLibroPrestado(Libro libro) {
        librosPrestados.add(libro);
    }

    public void removerLibroPrestado(Libro libro) {
        librosPrestados.remove(libro);
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
}
