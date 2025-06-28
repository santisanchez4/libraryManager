import models.Book;
import models.Library;
import enums.MenuOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        MenuOption option = null;

        do {
            MenuOption.printMenu();

            try {
                int input = Integer.parseInt(scanner.nextLine());
                option = MenuOption.fromCode(input);

                if (option == null) {
                    System.out.println("Opción inválida. Intente nuevamente.");
                    continue;
                }

                switch (option) {
                    case ADD_BOOK: {
                        System.out.print("Título: ");
                        String title = scanner.nextLine();
                        System.out.print("Autor: ");
                        String author = scanner.nextLine();
                        System.out.print("Año: ");
                        int year = Integer.parseInt(scanner.nextLine());

                        library.addBook(new Book(title, author, year));
                        break;
                    }
                    case SHOW_ALL: {
                        library.showAllBooks();
                        break;
                    }
                    case REMOVE_BY_TITLE: {
                        System.out.print("Ingrese el título del libro a eliminar: ");
                        String title = scanner.nextLine();
                        library.removeBook(title);
                        break;
                    }
                    case REMOVE_OLD: {
                        System.out.print("Ingrese el año límite: ");
                        int yearLimit = Integer.parseInt(scanner.nextLine());
                        library.removeOldBooks(yearLimit);
                        break;
                    }
                    case SEARCH_BY_AUTHOR: {
                        System.out.print("Ingrese el nombre del autor: ");
                        String author = scanner.nextLine();
                        library.searchByAuthor(author);
                        break;
                    }
                    case EXIT: {
                        System.out.println("Saliendo...");
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. Intente nuevamente.");
                option = null;
                continue;
            }

        } while (option != MenuOption.EXIT);

        scanner.close();
    }
}