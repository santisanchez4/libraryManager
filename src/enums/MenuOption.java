package enums;

public enum MenuOption {
    EXIT(0, "Salir"),
    ADD_BOOK(1, "Agregar libro"),
    SHOW_ALL(2, "Mostrar todos los libros"),
    REMOVE_BY_TITLE(3, "Eliminar libro por título"),
    REMOVE_OLD(4, "Eliminar libros anteriores al año"),
    SEARCH_BY_AUTHOR(5, "Buscar libros por autor");

    private final int code;
    private final String description;

    MenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static MenuOption fromCode(int code) {
        for (MenuOption option : values()) {
            if (option.code == code) return option;
        }
        return null;
    }

    public static void printMenu() {
        System.out.println("--- Biblioteca ---");
        for (MenuOption option : values()) {
            System.out.println(option.code + ". " + option.description);
        }
        System.out.print("Selecciona una opción: ");
    }
}