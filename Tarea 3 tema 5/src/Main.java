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

        scanner.close();
    }
}
