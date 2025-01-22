public class Prestados {

    public String libros;
    public int librosPrestados;
    public int librosDevueltos;
    private int librosPrestadosActualmente;

        public Prestados(){
            this.librosPrestados = 0;
            this.librosDevueltos = 0;
            this.librosPrestadosActualmente=0;    
        }


    public Prestados(int librosPrestados, int librosDevueltos, int librosPrestadosActualmente) {
        this.librosPrestados = librosPrestados;
        this.librosDevueltos = librosDevueltos;
        this.librosPrestadosActualmente = librosPrestadosActualmente;
    }


    @Override
    public String toString() {
        return "{" +
            " librosPrestados='" + getLibrosPrestados() + "'" +
            ", librosDevueltos='" + getLibrosDevueltos() + "'" +
            ", librosPrestadosActualmente='" + getLibrosPrestadosActualmente() + "'" +
            "}";
    }

    public int getLibrosPrestados() {
        return this.librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public int getLibrosDevueltos() {
        return this.librosDevueltos;
    }

    public void setLibrosDevueltos(int librosDevueltos) {
        this.librosDevueltos = librosDevueltos;
    }

    public int getLibrosPrestadosActualmente() {
        return this.librosPrestadosActualmente;
    }

    public void setLibrosPrestadosActualmente(int librosPrestadosActualmente) {
        this.librosPrestadosActualmente = librosPrestadosActualmente;
    }
    static class Usuario {
        String nombre;
        String contrasena;
        String rol; // "admin" o "usuario"
        String[] prestamosActivos;
        int numeroPrestamos;

        public Usuario(String nombre, String contrasena, String rol, int capacidadPrestamos) {
            this.nombre = nombre;
            this.contrasena = contrasena;
            this.rol = rol;
            this.prestamosActivos = new String[capacidadPrestamos];
            this.numeroPrestamos = 0;
        }

        public void agregarPrestamo(String libro) {
            if (numeroPrestamos < prestamosActivos.length) {
                prestamosActivos[numeroPrestamos++] = libro;
            }
        }

        public void eliminarPrestamo(String libro) {
            for (int i = 0; i < numeroPrestamos; i++) {
                if (prestamosActivos[i].equals(libro)) {
                    prestamosActivos[i] = prestamosActivos[--numeroPrestamos];
                    prestamosActivos[numeroPrestamos] = null;
                    break;
                }
            }
        }

        public boolean tienePrestamo(String libro) {
            for (int i = 0; i < numeroPrestamos; i++) {
                if (prestamosActivos[i].equals(libro)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Libro {
        String titulo;
        boolean prestado;

        public Libro(String titulo) {
            this.titulo = titulo;
            this.prestado = false;
        }
    }
    
}


