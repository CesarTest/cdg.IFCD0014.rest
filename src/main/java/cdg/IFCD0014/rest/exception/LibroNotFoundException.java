package cdg.IFCD0014.rest.exception;

public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(String message) {
        super(message);
    }
    public LibroNotFoundException() {
        super(" Book not found");
    }
}
