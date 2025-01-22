import java.util.ArrayList;
import java.util.List;

class Libro { // Variables para Libro
    private String titulo;
    private String autor;
    private String categoria;

    public void Libro(String titulo, String autor, String categoria) {// Constructor parametrizar
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Get and Set

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Titulo" + titulo + ", Autor" + autor + ", Categotia" + categoria;
    }

    // Funciones
    List<Libro> libros = new ArrayList<>();

    public void agregarLibro(String titulo, String autor, String categoria) {
        libros.add(new Libro());
        System.out.println("Libro agregado correctamente.");
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.titulo.equalsIgnoreCase(titulo));
        System.out.println("Libro eliminado si existía.");
    }

    public void buscarLibro(String criterio, String valor) {
        for (Libro libro : libros) {
            if ((criterio.equalsIgnoreCase("titulo") && libro.titulo.equalsIgnoreCase(valor)) ||
                    (criterio.equalsIgnoreCase("autor") && libro.autor.equalsIgnoreCase(valor)) ||
                    (criterio.equalsIgnoreCase("categoria") && libro.categoria.equalsIgnoreCase(valor))) {
                System.out.println(libro);
            }
        }
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
}
