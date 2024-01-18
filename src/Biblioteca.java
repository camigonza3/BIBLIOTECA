import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Libro> libros = new ArrayList();
    private Scanner scanner;

    public Biblioteca() {
        this.scanner = new Scanner(System.in);
    }

    public void agregarLibro() {
        try {
            System.out.println("Ingrese el título del libro:");
            String titulo = this.scanner.nextLine();
            System.out.println("Ingrese el autor del libro:");
            String autor = this.scanner.nextLine();
            this.libros.add(new Libro(titulo, autor));
            System.out.println("Libro agregado con éxito.");
        } catch (InputMismatchException var3) {
            System.out.println("Error: Entrada no válida.");
            this.scanner.nextLine();
        }

    }

    public void prestarLibro() throws LibroNoDisponibleException, LibroNoEncontradoException {
        System.out.println("Ingrese el título del libro a prestar:");
        String titulo = this.scanner.nextLine();
        Libro libro = this.buscarLibro(titulo);
        if (!libro.isDisponible()) {
            throw new LibroNoDisponibleException("El libro no está disponible.");
        } else {
            libro.setDisponible(false);
            System.out.println("Libro prestado con éxito.");
        }
    }

    public void devolverLibro() throws LibroNoEncontradoException {
        System.out.println("Ingrese el título del libro a devolver:");
        String titulo = this.scanner.nextLine();
        Libro libro = this.buscarLibro(titulo);
        libro.setDisponible(true);
        System.out.println("Libro devuelto con éxito.");
    }

    private Libro buscarLibro(String titulo) throws LibroNoEncontradoException {
        Iterator var2 = this.libros.iterator();

        Libro libro;
        do {
            if (!var2.hasNext()) {
                throw new LibroNoEncontradoException("Libro no encontrado.");
            }

            libro = (Libro)var2.next();
        } while(!libro.getTitulo().equalsIgnoreCase(titulo));

        return libro;
    }

    public void mostrarLibros() {
        if (this.libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("Lista de Libros:");
            Iterator var1 = this.libros.iterator();

            while(var1.hasNext()) {
                Libro libro = (Libro)var1.next();
                System.out.println(libro);
            }
        }

    }
}
