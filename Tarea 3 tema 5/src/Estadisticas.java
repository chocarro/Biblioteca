import java.util.HashMap;
import java.util.Map;

public class Estadisticas {
    private static Usuario[] usuarios;
        public int librostotalesyactivos;
        public int listarlibrosprestados;
        public int usuariomasactivo;
        
        public void EstadísticasyReportes(){
        this.librostotalesyactivos = 0;
        this.listarlibrosprestados = 0;
        this.usuariomasactivo = 0;
        }
    
    
        @Override
        public String toString() {
            return "{" +
                " librostotalesyactivos='" + getLibrostotalesyactivos() + "'" +
                ", listarlibrosprestados='" + getListarlibrosprestados() + "'" +
                ", usuariomasactivo='" + getUsuariomasactivo() + "'" +
                "}";
        }
    
        public int getLibrostotalesyactivos() {
            return this.librostotalesyactivos;
        }
    
        public void setLibrostotalesyactivos(int librostotalesyactivos) {
            this.librostotalesyactivos = librostotalesyactivos;
        }
    
        public int getListarlibrosprestados() {
            return this.listarlibrosprestados;
        }
    
        public void setListarlibrosprestados(int listarlibrosprestados) {
            this.listarlibrosprestados = listarlibrosprestados;
        }
    
        public int getUsuariomasactivo() {
            return this.usuariomasactivo;
        }
    
        public void setUsuariomasactivo(int usuariomasactivo) {
            this.usuariomasactivo = usuariomasactivo;
        }
    
        @SuppressWarnings("unused")
        private static void mostrarEstadisticas() {
            System.out.println("\n--- Estadísticas y Reportes ---");
    
            // Número total de préstamos activos
            int prestamosActivos = 0;
            for (Usuario usuario : usuarios) {
            if (usuario != null) {
                prestamosActivos += usuario.numeroPrestamos;
            }
        }
        System.out.println("Número total de préstamos activos: " + prestamosActivos);

        // Libros más prestados (conteo básico)
        Map<String, Integer> conteoLibros = new HashMap<>();
        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                for (int i = 0; i < usuario.numeroPrestamos; i++) {
                    String libro = usuario.prestamosActivos[i];
                    conteoLibros.put(libro, conteoLibros.getOrDefault(libro, 0) + 1);
                }
            }
        }
        System.out.println("Libros más prestados: " + conteoLibros);

        // Usuario con más préstamos activos
        Usuario mayorUsuario = null;
        for (Usuario usuario : usuarios) {
            if (usuario != null && (mayorUsuario == null || usuario.numeroPrestamos > mayorUsuario.numeroPrestamos)) {
                mayorUsuario = usuario;
            }
        }

        if (mayorUsuario != null) {
            System.out.println("Usuario con más préstamos activos: " + mayorUsuario.getNombre());
        }
    }
}