import java.util.List;

class Usuario { // Variables para Usuarios
    String nombre;
    private String id;
    private String contraseña;
    private String rol;
    private List<Libro> librosPrestados;
    public int numeroPrestamos;
    public String[] prestamosActivos;

    public  Usuario(String nombre, String id, String contraseña, String rol, List<Libro> librosPrestados) {// Constructor parametrizar
        this.nombre = nombre;
        this.id = id;
        this.contraseña = contraseña;
        this.rol = rol;
        this.librosPrestados=librosPrestados;
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

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(List<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    @Override
    public String toString() {
        return "Nombre" + nombre + ", Id" + id;
    }

    public void agregarLibroPrestados(Libro libro) {
        librosPrestados.add(libro);
        System.out.println("Libro agregado correctamente.");
    }

    public void eliminarLibroPrestados(Libro libro) {
        librosPrestados.remove(libro);
        System.out.println("Libro eliminado si existía.");
    }

}