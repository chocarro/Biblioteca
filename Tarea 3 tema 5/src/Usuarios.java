 class Usuarios { //Variables para Usuarios
        private String nombre;
        private String id;
 
     public void Usuarios (String titulo, String autor, String categoria) {//Constructor parametrizar
     
         this.nombre=nombre;
         this.id=id;
     }
 
        //Get and Set 

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
         return "Nombre" + nombre + ", Id" + id ;
     }


     //Funciones

     public static void registrarusuarios () {
        
     }

     public static void consultarinformacion () {
        
     }

 }
    

