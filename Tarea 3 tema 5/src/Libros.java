import java.util.ArrayList;
import java.util.List;

class Libro { //Variables para Libro
     private String titulo;
     private String autor;
     private String categoria;
     
 
     public void Libro (String titulo, String autor, String categoria) {//Constructor parametrizar
     
         this.titulo=titulo;
         this.autor=autor;
         this.categoria=categoria;

     }

    //Get and Set 


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

     //Funciones

     private List libros = new ArrayList<>();
     private List usuarios = new ArrayList<>();
     
     public String agregarlibrosnuevos() {
        libros.add (new Libro (titulo, autor, categoria));

     }

     public  String eliminarlibrosexistentes() {
        libros.removeIf (libro -> libro.titulo.equalsIgnoreCase(libro));
        
     }

     public static void buscarlibros() {
        
     }

     public static void mostrardisponibles() {
        
     }
}
