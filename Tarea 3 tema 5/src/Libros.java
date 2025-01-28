class Libro { // Variables para Libro
    private String titulo;
    private String autor;
    private String categoria;
    private boolean estaPrestado;

    public Libro(String titulo, String autor, String categoria, Boolean estaPrestado) {// Constructor parametrizar
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.estaPrestado=estaPrestado;
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

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }
    @Override
    public String toString() {
        return "Titulo" + titulo + ", Autor" + autor + ", Categotia" + categoria;
    }
    
}
