import java.util.ArrayList;
import java.util.List;

class Usuario { // Variables para Usuarios
    String nombre;
    private String id;

    public void Usuarios(String titulo, String autor, String categoria) {// Constructor parametrizar

        this.nombre = nombre;
        this.id = id;
    }

    // Get and Set

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nombre" + nombre + ", Id" + id;
    }

    // Funciones

private List<Usuario> usuarios = new ArrayList<>();
public int numeroPrestamos;
public String[] prestamosActivos;
   
public void registrarUsuario(String nombre, String id) {
    usuarios.add(new Usuario());
    System.out.println("Usuario registrado correctamente.");
}

public void consultarInformacion() {
    if (usuarios.isEmpty()) {
        System.out.println("No hay usuarios registrados.");
    } else {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

}
}