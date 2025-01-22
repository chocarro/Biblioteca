import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays para almacenar libros y usuarios
        Libro[] libros = new Libro[100];
        Usuario[] usuarios = new Usuario[50];
        int contadorLibros = 0;
        int contadorUsuarios = 0;

        int opcion;

        // Crear usuarios y libros de prueba
        usuarios[0] = new Usuario();
        usuarios[1] = new Usuario();

        libros[0] = new Libro();
        libros[1] = new Libro();

        Usuario usuarioLogueado = null;

        // Pantalla de inicio de sesión
        while (usuarioLogueado == null) {
            System.out.println("=== Inicio de Sesión ===");
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.nextLine();

            for (Usuario usuario : usuarios) {
                if (usuario != null && usuario.getNombre().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                    usuarioLogueado = usuario;
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
                        if (contadorLibros < libros.length) {
                            System.out.print("Ingrese título: ");
                            String titulo = scanner.nextLine();
                            System.out.print("Ingrese autor: ");
                            String autor = scanner.nextLine();
                            System.out.print("Ingrese categoría: ");
                            String categoria = scanner.nextLine();
                            libros[contadorLibros++] = new Libro();
                            System.out.println("Libro agregado correctamente.");
                        } else {
                            System.out.println("No se pueden agregar más libros. Capacidad llena.");
                        }
                    } else if (usuarioLogueado.getRol().equals("usuario")) {
                        // Buscar libro
                        System.out.print("Ingrese el título del libro a buscar: ");
                        String tituloBuscar = scanner.nextLine();
                        boolean encontrado = false;
                        for (int i = 0; i < contadorLibros; i++) {
                            if (libros[i].getTitulo().equalsIgnoreCase(tituloBuscar)) {
                                System.out.println(libros[i]);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Libro no encontrado.");
                        }
                    }
                    break;
                case 2:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Eliminar libro
                        System.out.print("Ingrese título del libro a eliminar: ");
                        String tituloEliminar = scanner.nextLine();
                        boolean eliminado = false;
                        for (int i = 0; i < contadorLibros; i++) {
                            if (libros[i].getTitulo().equalsIgnoreCase(tituloEliminar)) {
                                libros[i] = libros[--contadorLibros];
                                libros[contadorLibros] = null;
                                System.out.println("Libro eliminado correctamente.");
                                eliminado = true;
                                break;
                            }
                        }
                        if (!eliminado) {
                            System.out.println("Libro no encontrado.");
                        }
                    } else if (usuarioLogueado.getRol().equals("usuario")) {
                        // Mostrar todos los libros
                        if (contadorLibros == 0) {
                            System.out.println("No hay libros disponibles.");
                        } else {
                            for (int i = 0; i < contadorLibros; i++) {
                                System.out.println(libros[i]);
                            }
                        }
                    }
                    break;
                case 3:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Mostrar todos los libros
                        if (contadorLibros == 0) {
                            System.out.println("No hay libros disponibles.");
                        } else {
                            for (int i = 0; i < contadorLibros; i++) {
                                System.out.println(libros[i]);
                            }
                        }
                    }
                    break;
                case 4:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Registrar usuario
                        if (contadorUsuarios < usuarios.length) {
                            System.out.print("Ingrese nombre del usuario: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese ID del usuario: ");
                            String id = scanner.nextLine();
                            System.out.print("Ingrese contraseña: ");
                            String contraseña = scanner.nextLine();
                            System.out.print("Ingrese rol (admin/usuario): ");
                            String rol = scanner.nextLine();
                            usuarios[contadorUsuarios++] = new Usuario();
                            System.out.println("Usuario registrado correctamente.");
                        } else {
                            System.out.println("No se pueden registrar más usuarios. Capacidad llena.");
                        }
                    }
                    break;
                case 5:
                    if (usuarioLogueado.getRol().equals("admin")) {
                        // Mostrar usuarios registrados
                        if (contadorUsuarios == 0) {
                            System.out.println("No hay usuarios registrados.");
                        } else {
                            for (int i = 0; i < contadorUsuarios; i++) {
                                System.out.println(usuarios[i]);
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        
    


//CONSOLA BIBLIOTECA

        do {
            System.out.println("\n--- Menú de Gestión ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Registrar usuario");
            System.out.println("6. Mostrar usuarios registrados");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    if (contadorLibros < libros.length) {
                        System.out.print("Ingrese título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Ingrese categoría: ");
                        String categoria = scanner.nextLine();
                        libros[contadorLibros++] = new Libro();
                        System.out.println("Libro agregado correctamente.");
                    } else {
                        System.out.println("No se pueden agregar más libros. Capacidad llena.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese título del libro a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < contadorLibros; i++) {
                        if (libros[i].getTitulo().equalsIgnoreCase(tituloEliminar)) {
                            libros[i] = libros[--contadorLibros];
                            libros[contadorLibros] = null;
                            System.out.println("Libro eliminado correctamente.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Buscar por (titulo/autor/categoria): ");
                    String criterio = scanner.nextLine();
                    System.out.print("Ingrese valor: ");
                    String valor = scanner.nextLine();
                    boolean libroEncontrado = false;
                    for (int i = 0; i < contadorLibros; i++) {
                        Libro libro = libros[i];
                        if ((criterio.equalsIgnoreCase("titulo") && libro.getTitulo().equalsIgnoreCase(valor)) ||
                                (criterio.equalsIgnoreCase("autor") && libro.getAutor().equalsIgnoreCase(valor)) ||
                                (criterio.equalsIgnoreCase("categoria")
                                        && libro.getCategoria().equalsIgnoreCase(valor))) {
                            System.out.println(libro);
                            libroEncontrado = true;
                        }
                    }
                    if (!libroEncontrado) {
                        System.out.println("No se encontraron libros con ese criterio.");
                    }
                    break;
                case 4:
                    if (contadorLibros == 0) {
                        System.out.println("No hay libros disponibles.");
                    } else {
                        for (int i = 0; i < contadorLibros; i++) {
                            System.out.println(libros[i]);
                        }
                    }
                    break;
                case 5:
                    if (contadorUsuarios < usuarios.length) {
                        System.out.print("Ingrese nombre del usuario: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese ID del usuario: ");
                        String id = scanner.nextLine();
                        usuarios[contadorUsuarios++] = new Usuario();
                        System.out.println("Usuario registrado correctamente.");
                    } else {
                        System.out.println("No se pueden registrar más usuarios. Capacidad llena.");
                    }
                    break;
                case 6:
                    if (contadorUsuarios == 0) {
                        System.out.println("No hay usuarios registrados.");
                    } else {
                        for (int i = 0; i < contadorUsuarios; i++) {
                            System.out.println(usuarios[i]);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 7);

       
    }

}