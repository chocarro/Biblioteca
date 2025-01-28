import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    // Funciones
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {// Constructor parametrizar
        this.libros = new ArrayList<Libro>();
        this.usuarios=new ArrayList<Usuario>();
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado correctamente.");
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
        System.out.println("Libro eliminado si existía.");
    }

    public Libro buscarLibro(String criterio, String valor) {
        for (Libro libro : libros) {
            if ((criterio.equalsIgnoreCase("titulo") && libro.getTitulo().equalsIgnoreCase(valor)) ||
                    (criterio.equalsIgnoreCase("autor") && libro.getAutor().equalsIgnoreCase(valor)) ||
                    (criterio.equalsIgnoreCase("categoria") && libro.getCategoria().equalsIgnoreCase(valor))) {
                System.out.println(libro);
                return libro;
            }
        }
        return null;
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros disponibles.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
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
