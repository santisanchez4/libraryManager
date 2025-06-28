package models;
import java.util.Iterator;
import java.util.LinkedList;

public class Library {
    private LinkedList<Book> books = new LinkedList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(" Libro agregado correctamente");
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println(" Lista de libros: ");
            for (Book book : books) {
                System.out.println(book);
            }
        }      
    }
    
    public void removeBook(String title) {
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Libro liminado: " + book);
                return;
            } 
            System.out.println("No se encontró ningún libro con el título: \"" + title + "\".");;
        }
    }

    public void removeOldBooks(int yearLimit) {
        Iterator<Book> iterator = books.iterator();
        boolean removedAny = false;

        while (iterator.hasNext()) {
            Book book = iterator.next();
            iterator.remove();
            if (book.getYear() < yearLimit) {
                removedAny = true;
                System.out.println("Eliminando: " + book);
            }
        }

        if (!removedAny) {
            System.out.println("No se enconetraron libros anteriores al año: " + yearLimit + ".");
        }
    }

    public void searchByAuthor(String authorQuery) {
    boolean found = false;
    String queryLower = authorQuery.toLowerCase();

    for (Book book : books) {
        if (book.getAuthor().toLowerCase().contains(queryLower)) {
            System.out.println(book);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No se encontraron libros del autor: " + authorQuery);
    }
    }
}