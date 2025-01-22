public class Estadisticas {
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


}
