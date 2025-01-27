import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays para almacenar libros y usuarios
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        Usuario usuario = new Usuario("Pepe", "1234", "1234", "usuario", null);
        Usuario admin = new Usuario("Maria", "4321", "4321", "admin", null);

        Libro prueba1 = new Libro("Prueba1", "Pepe", "Terror", false);
        Libro prueba2 = new Libro("Prueba2", " Maria", "Fantasia", false);
        Libro prueba3 = new Libro("Prueba3", " Elena", "Amor", false);

        biblioteca.agregarLibro(prueba1);
        biblioteca.agregarLibro(prueba2);
        biblioteca.agregarLibro(prueba3);

        biblioteca.registrarUsuario(usuario);
        biblioteca.registrarUsuario(admin);

        Usuario usuarioLogueado = null;

        // Pantalla de inicio de sesión
        while (usuarioLogueado == null) {
            System.out.println("=== Inicio de Sesión ===");
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.nextLine();

            for (Usuario usuario1 : biblioteca.getUsuarios()) {
                if (usuario1 != null && usuario1.getNombre().equals(nombreUsuario)
                        && usuario1.getContraseña().equals(contraseña)) {
                    usuarioLogueado = usuario1;
                    System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuarioLogueado.getNombre() + "!");
                    break;
                }
            }

            if (usuarioLogueado == null) {
                System.out.println("Usuario o contraseña incorrectos. Intente nuevamente.");
            }
        }

        // Menú interactivo según el rol del usuario

        do {
            System.out.println("\n=== Menú de Gestión ===");
            if (usuarioLogueado.getRol().equals("admin")) {
                System.out.println("1. Agregar libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Mostrar todos los libros");
                System.out.println("4. Registrar usuario");
                System.out.println("5. Mostrar usuarios registrados");
            } else if (usuarioLogueado.getRol().equals("usuario")) {
                System.out.println("1. Buscar libro");
                System.out.println("2. Mostrar todos los libros");
            }
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Agregar libro

                        System.out.print("Ingrese título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Ingrese categoría: ");
                        String categoria = scanner.nextLine();
                        Libro nuevoLibro = new Libro(titulo, autor, categoria, false);
                        biblioteca.agregarLibro(nuevoLibro);
                        System.out.println("Libro agregado correctamente.");

                    } else if (usuarioLogueado.getRol().equals("usuario")) {
                        // Buscar libro
                        System.out.print("¿Porque cual criterio quieres buscar? ");
                        System.out.print("1.titulo");
                        System.out.print("2.categoria");
                        System.out.print("3.autor");

                        int opcion1 = scanner.nextInt();
                        switch (opcion1) {
                            case 1:
                                System.out.print("Escribe el titulo del libro");
                                String titulo = scanner.nextLine();
                                biblioteca.buscarLibro("titulo", titulo);

                                break;
                            case 2:
                                System.out.print("Escribe la categoria del libro");
                                String categoria = scanner.nextLine();
                                biblioteca.buscarLibro("categoria", categoria);
                                break;
                            case 3:
                                System.out.print("Escribe el autor del libro");
                                String autor = scanner.nextLine();
                                biblioteca.buscarLibro("autor", autor);
                                break;

                            default:
                                break;
                        }

                    }
                    break;
                    
                case 2:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Eliminar libro
                        System.out.print("Escribe el titulo del libro");
                                String titulo = scanner.nextLine();
                                Libro libroEliminar= biblioteca.buscarLibro("titulo", titulo);
                                biblioteca.eliminarLibro(libroEliminar);

                    } else if (usuarioLogueado.getRol().equals("usuario")) {
                        // Mostrar todos los libros
                       biblioteca.mostrarLibros();
                    }
                    break;
                case 3:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Mostrar todos los libros
                       biblioteca.mostrarLibros();
                    }
                    break;
                case 4:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Registrar usuario
                        System.out.print("Ingrese nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese identificador: ");
                        String identificador = scanner.nextLine();
                        System.out.print("Ingrese contraseña: ");
                        String contraseña = scanner.nextLine();
                        Usuario nuevoUsuario= new Usuario(nombre, identificador, contraseña, "usuario", null);
                        biblioteca.registrarUsuario(nuevoUsuario);
                    }
                    break;
                case 5:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Mostrar usuarios registrados
                        biblioteca.consultarInformacion();
                    }
                    break;
                case 0:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

    }

}