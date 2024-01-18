import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Seleccione una opción: \n1. Agregar Libro \n2. Prestar Libro \n3. Devolver Libro \n4. Mostrar Libros \n5. Salir");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consume la línea nueva restante

                switch (opcion) {
                    case 1:
                        biblioteca.agregarLibro();
                        break;
                    case 2:
                        biblioteca.prestarLibro();
                        break;
                    case 3:
                        biblioteca.devolverLibro();
                        break;
                    case 4:
                        biblioteca.mostrarLibros();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            } catch (LibroNoDisponibleException | LibroNoEncontradoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
